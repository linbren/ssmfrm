package net.business.system.service;

import java.util.List;

import net.business.system.entity.TsDictionary;
import net.platform.utils.page.PageUtil;

/**
 * 
 * 功能描述：字典服务
 * 
 * @author 
 * 
 * 
 *        <p>
 *        修改历史：(修改人，修改时间，修改原因/内容)
 *        </p>
 */
public interface DictionaryService  {

    public String query(PageUtil pageUtil, TsDictionary TsDictionary) throws Exception;
    public TsDictionary getById(int id);
}
