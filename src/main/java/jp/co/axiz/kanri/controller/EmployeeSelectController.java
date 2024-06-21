package jp.co.axiz.kanri.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.kanri.entity.Employee;
import jp.co.axiz.kanri.form.EmployeeSelectForm;
import jp.co.axiz.kanri.service.EmployeeService;
import jp.co.axiz.kanri.util.ParamUtil;

/*
 * 社員情報検索用コントローラ
 */

@Controller
public class EmployeeSelectController {

	/*
     * messages_ja.propertiesのメッセージ取得用
     */
    @Autowired
    MessageSource messageSource;

    /*
     * ユーザ情報サービス
     */
    @Autowired
    private EmployeeService eService;

    /*
     * 検索画面表示
     */
    @RequestMapping("/employeeSelect")
    public String empSelect(@ModelAttribute("employeeSelect") EmployeeSelectForm form, Model model) {
        return "employeeSelect";
    }

    /*
     * 検索結果画面表示 (検索画面の検索ボタン押下時)
     */
    @RequestMapping(value = "/employeeSelectResult", method = RequestMethod.POST)
    public String list(@Validated @ModelAttribute("employeeSelect") EmployeeSelectForm form, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "employeeSelect";
        }


        // 検索条件をEntityにセット
        Employee condition = new Employee(
                form.getEmpId(),
                form.getEmpName(),
                form.getEmpKana(),
                form.getTel());

        if (ParamUtil.isAllNullOrEmpty(
        		form.getEmpId(),
                form.getEmpName(),
                form.getEmpKana(),
                form.getTel())) {

        	String errMsg = messageSource.getMessage("all.null.error", null, Locale.getDefault());
            model.addAttribute("errMsg", errMsg);

        	return "employeeSelect";
        }

        // 検索処理
        List<Employee> empInfo = eService.find(condition);

        if (empInfo.isEmpty() || empInfo == null) {
            // 検索結果が無い場合
            String errMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
            model.addAttribute("errMsg", errMsg);
            return "employeeSelect";
        } else {
            // 検索結果がある場合
            model.addAttribute("empInfo", empInfo);
            return "employeeSelectResult";
        }
    }
}
