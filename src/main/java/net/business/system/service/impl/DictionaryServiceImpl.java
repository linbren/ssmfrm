package net.business.system.service.impl;

import net.business.system.dao.TsDictionaryMapper;
import net.business.system.entity.TsDictionary;
import net.business.system.service.DictionaryService;
import net.platform.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 功能描述：字典服务
 * 
 * @author yiting lin
 * @Email 
 * 
 *        <p>
 *        修改历史：(修改人，修改时间，修改原因/内容)
 *        </p>
 */
@Service("dictionaryService")
@Transactional
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private TsDictionaryMapper dictDao;
    public String query(PageUtil pageUtil, TsDictionary TsDictionary) throws Exception {
        String sQrySql="select * from TS_DICTIONARY where 1=1 ";
        String sCntSql="select count(*) from TS_DICTIONARY where 1=1 ";
        
        if(TsDictionary.getDictType() != null && !TsDictionary.getDictType().equals("")){
        	sQrySql += " and DICT_TYPE = '" + TsDictionary.getDictType() + "'";
        	sCntSql += " and DICT_TYPE = '" + TsDictionary.getDictType() + "'";
        }
        
        if(TsDictionary.getItemValue() != null && !TsDictionary.getItemValue().equals("")){
        	sQrySql += " and ITEM_NAME like '%" + TsDictionary.getItemValue() + "%'";
        	sCntSql += " and ITEM_NAME like '%" + TsDictionary.getItemValue() + "%'";
        }
        
        if(TsDictionary.getItemName() != null && !TsDictionary.getItemName().equals("")){
        	sQrySql += " and ITEM_NAME like '%" + TsDictionary.getItemName() + "%'";
        	sCntSql += " and ITEM_NAME like '%" + TsDictionary.getItemName() + "%'";
        }
        
    	return JSON.toJSONString(sQrySql);
    	
    }


    /**
     * 
     * 功能描述：根据id获取字典
     * 
     * @author yiting lin
     * @Email 
     *        <p>
     *        创建日期 ：2016-7-18 下午03:20:41
     *        </p>
     * 
     * @param id
     * @return TsDictionary
     * 
     *         <p>
     *         修改历史 ：(修改人，修改时间，修改原因/内容)
     *         </p>
     */
    public TsDictionary getById(int id) {
        int sId = 393;
        TsDictionary dict=new TsDictionary();
        try{
              dict = dictDao.selectByPrimaryKey(sId);
             System.out.println(dict.getItemCode() + " ===================== "+dict.getItemValue());
        }catch(Exception e){
            System.out.println("dictDao.selectByPrimaryKey: "+e.getMessage());
        }
        return dict;
    }
 
}
