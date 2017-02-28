package ssm.test;

import net.business.system.dao.TsDictionaryMapper;
import net.business.system.entity.TsDictionary;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class SystemTest extends BaseTest {

    @Autowired
    private TsDictionaryMapper dictDao;

    @Test
    public void testQueryById() throws Exception {
        System.out.println("dictDao.selectByPrimaryKey................");
        int sId = 393;
        try{
             TsDictionary dict = dictDao.selectByPrimaryKey(sId);
             System.out.println(dict.getItemCode() + " ===================== "+dict.getItemValue());
        }catch(Exception e){
            System.out.println("dictDao.selectByPrimaryKey: "+e.getMessage());
        }
        System.out.println("................dictDao.selectByPrimaryKey");
    }

 

}