package ichiwan.web.servlet.utils;

import ichiwan.Validator.ErrorsUtils;
import ichiwan.web.servlet.web.HandOutServlet;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ServletUtils {
    private static Properties dispatchServletProperties = null;

    static {
        try {
            dispatchServletProperties = new Properties();
            dispatchServletProperties.load(
                    HandOutServlet.class.getClassLoader().getResourceAsStream(
                            "dispatchServlet.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("ServletUtils 初始化成功! 读取 dispatchServletProperties");
    }

    /**
     * see dispatchIfHasProperties(r, r, k ,s)
     * get key and servletDispatched from properties
     *
     * @param request  来源请求
     * @param response 来源响应
     */
    public static void dispatchAsParameterInProperties(javax.servlet.http.HttpServletRequest request,
                                                       javax.servlet.http.HttpServletResponse response
    ) {
        boolean isDispatch = false;

        for (String key : dispatchServletProperties.stringPropertyNames()) {
            if (isDispatch) {
                //已转发，不用继续搜索了
                break;
            } else {
                //未转发，继续尝试，并接收转发结果
                isDispatch = dispatchIfHasProperties(request, response, key, dispatchServletProperties.getProperty(key));
            }
        }

        if (!isDispatch) {
            //遍历完仍未转发，则发默认
            System.out.println("分发默认servlet");
            dispatchDefaultServlet(request, response);
        }
    }

    public static boolean dispatchDefaultServlet(javax.servlet.http.HttpServletRequest request,
                                                 javax.servlet.http.HttpServletResponse response) {
        try {
            request.getRequestDispatcher(
                    dispatchServletProperties.getProperty("defaultDispatch"))
                    .forward(request, response);
            return true;
        } catch (Exception e) {
            ErrorsUtils.addErrorToErrors(request,
                    "error in dispatchAsParameterInProperties when " +
                            dispatchServletProperties.getProperty("defaultDispatch")
                            + " because " + e.getMessage());
            return false;
        }

    }


    /**
     * 若request中存在attribute key，则快速转发到制定的servlet
     *
     * @param request           来源请求
     * @param response          来源响应
     * @param key               键值对 attribute
     * @param servletDispatched 转发目的servlet
     * @return 是否成功转发
     */
    public static boolean dispatchIfHasProperties(javax.servlet.http.HttpServletRequest request,
                                                  javax.servlet.http.HttpServletResponse response
            , String key, String servletDispatched) {
        if (request.getParameter(key) != null) {
            try {
//                System.out.println(servletDispatched);
                request.getRequestDispatcher(servletDispatched).forward(request, response);
            } catch (Exception e) {
                ErrorsUtils.addErrorToErrors(request,
                        "error in dispatchAsParameterInProperties when " + key + " because " + e.getMessage());
                return false;
            }
            return true;
        }

        return false;
    }

    /**
     * 速度dispatch
     *
     * @param request           来源请求
     * @param response          来源响应
     * @param servletDispatched 转发目的servlet/jsp
     */
    public static void dispatch(javax.servlet.http.HttpServletRequest request,
                                javax.servlet.http.HttpServletResponse response,
                                String servletDispatched) {
        try {
            request.getRequestDispatcher(servletDispatched).forward(request, response);
        } catch (Exception e) {
            ErrorsUtils.addErrorToErrors(request,
                    "error in dispatch when to " + servletDispatched + " because " + e.getMessage());
        }
    }

    /**
     * 如果Attribute不存在则添加之
     *
     * @param request javax.servlet.http.HttpServletRequest
     * @param key     键
     * @param value   值
     */
    public static void addAttributeIfNotExists(javax.servlet.http.HttpServletRequest request,
                                               String key, Object value) {
        final Object attribute = request.getAttribute(key);
        if (attribute == null) {
            request.setAttribute(key, value);
        }
    }

    public static void dispatchToViewJSP(javax.servlet.http.HttpServletRequest request,
                                         javax.servlet.http.HttpServletResponse response
    ) {
        try {
            request.getRequestDispatcher(dispatchServletProperties.getProperty("viewJSP")).forward(request, response);
        } catch (Exception e) {
            ErrorsUtils.addErrorToErrors(request,
                    "error in dispatchToViewJSP when to viewJSP as"
                            + dispatchServletProperties.getProperty("viewJSP")
                            + " because " + e.getMessage());
        }
    }

    public static Map<String, String[]> getParameterMap(javax.servlet.http.HttpServletRequest request
            , String... keys) {
        Map<String, String[]> map = new HashMap<>();

        for (String key : keys) {
            map.put(key, request.getParameterValues(key));
        }
        return map;
    }

    public static boolean hasParameterOrAttribute(javax.servlet.http.HttpServletRequest request
            , String key) {
        final String parameter = request.getParameter(key);
        final Object attribute = request.getAttribute(key);
        if (parameter == null && attribute == null) {
            //都是null，才返回false
            return false;
        } else {
            return true;
        }

    }


    public static Properties getDispatchServletProperties() {
        return dispatchServletProperties;
    }
}
