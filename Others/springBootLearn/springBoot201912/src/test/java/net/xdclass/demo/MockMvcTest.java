package net.xdclass.demo;

import net.xdclass.demo.application.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Description
 * learn MockMvc
 *
 * 为何使用MockMvc？
 *  对模块进行集成测试时，希望能够通过输入URL对Controller进行测试，
 * 如果通过启动服务器，建立http client进行测试，这样会使得测试变得
 * 很麻烦，比如，启动速度慢，测试验证不方便，依赖网络环境等，所以为
 * 了可以对Controller进行测试，我们引入了MockMVC。
 *  MockMvc实现了对Http请求的模拟，能够直接使用网络的形式，转换到
 * Controller的调用，这样可以使得测试速度快、不依赖网络环境，而且提
 * 供了一套验证的工具，这样可以使得请求的验证统一而且很方便。
 * ————————————————
 * 版权声明：本文为CSDN博主「Bekoe」的原创文章，遵循 CC 4.0 BY 版权
 * 协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/kqZhu/article/details/78836275
 *
 * <p>
 * Data
 * 2019/12/16 12:12
 *
 * @author zrx
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
@AutoConfigureMockMvc
public class MockMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void apiTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

//        mvcResult.getResponse().getWriter()
//        System.out.println(mvcResult);
        //org.springframework.test.web.servlet.DefaultMvcResult@1c1fe0b
    }
}
