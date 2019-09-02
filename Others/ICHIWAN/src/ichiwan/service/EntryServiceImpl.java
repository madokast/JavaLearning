package ichiwan.service;

import ichiwan.dao.EntryDao;
import ichiwan.dao.EntryDaoImpl;
import ichiwan.dao.EntryTailDao;
import ichiwan.dao.EntryTailDaoImpl;
import ichiwan.domain.Entry;
import ichiwan.domain.EntryForm;
import java.util.List;

public class EntryServiceImpl implements EntryService {
    private final EntryDao entryDao = new EntryDaoImpl();
    private final EntryTailDao entryTailDao = new EntryTailDaoImpl();

    @Override
    public void addEntry(EntryForm entryForm) {
        entryDao.addEntry(entryForm);
    }

    @Override
    public List<Entry> findAll() {
        return entryDao.findAll();
    }

    @Override
    public void deleteEntry(int id) {
        entryDao.deleteEntry(id);
    }

    @Override
    public int EntryNumber() {
        return entryTailDao.entryNumber();
    }

    @Override
    public Entry queryEntryById(int id) {
        return entryDao.queryEntryById(id);
    }
}
