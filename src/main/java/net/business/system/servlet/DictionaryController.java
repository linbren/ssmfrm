package net.business.system.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.business.system.entity.TsDictionary;
import net.business.system.service.DictionaryService;
import net.platform.utils.ServletUtils;
import net.platform.utils.page.PageUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 功能描述：字典管理
 * 
 * @author  
 * @Email  
 * 
 *        <p>
 *        修改历史：(修改人，修改时间，修改原因/内容)
 *        </p>
 */
@Controller
@RequestMapping("/dict")
public class DictionaryController extends BaseController {
	
	private static Log log = LogFactory.getLog(DictionaryController.class);
	
    @Autowired
    private DictionaryService dictionaryService;
  
    /**
     * 
     * 功能描述：跳转到列表页面
     * 
     * @author yiting lin
     * @Email 
     *        <p>
     *        创建日期 ：
     *        </p>
     * 
     * @param request
     * @return
     */
    @RequestMapping(params = "goList")
    public ModelAndView goList(HttpServletRequest request) {

        return new ModelAndView("system/dictionary/dictionary_list");
    }
    /**
	 * 功能描述：跳转到新增页面
	 * 
	 * @param tsRole
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HttpServletRequest request){
		return new ModelAndView("system/dictionary/dictionary_edit");
	}
    
    /**
     * 功能描述：跳转到字典类型修改页面
     * @author zhangxin
     * @Email
     * 		<p>
     *        
     *      </p>
     * 		
     * @param request
     * @return
     */
    @RequestMapping(params = "goEditType")
    public ModelAndView goEditType(HttpServletRequest request){
    	return new ModelAndView("system/dictionary/dict_type_edit");
    }
    
    /**
     * 
     * 功能描述：列表请求数据
     * 
     * @author 
     * @Email 
     *        <p>
     *        
     *        </p>
     * 
     * @param dictionary
     * @param pageUtil
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "getList")
    public void getList(PageUtil pageUtil, TsDictionary dictionary, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        //String jsonStr = dictionaryService.query(pageUtil, dictionary);
    	
    	TsDictionary dict = dictionaryService.getById(339);
        ServletUtils.outPrintObjectToJson(response, dict);
        
    }
}
