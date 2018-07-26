package com.utry.openticket.controller;

/**
 * @Description : 工单controller
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import com.utry.openticket.dto.TicketDTO;
import com.utry.openticket.model.TicketFieldDO;
import com.utry.openticket.model.TicketTypeDO;
import com.utry.openticket.service.TicketFieldService;
import com.utry.openticket.service.TicketService;
import com.utry.openticket.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class TicketController {

    @Autowired
    private TicketFieldService ticketFieldService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketTypeService ticketTypeService;

    /**
     *
     * 功能描述 : 打开table_future页面
     *
     * @param : Model
     * @return :
     * @auther : LVDING
     * @date : 2018-07-26
     */
    @RequestMapping("index")
    public String index(Model model){
        List<TicketTypeDO> ticketTypeList = ticketTypeService.getTicketTypeList();
        model.addAttribute("ticketTypeList",ticketTypeList);
        return "/table_future";
    }

    /**
     *
     * 功能描述 : 获得工单的自定义列
     *
     * @param : String ticketType 工单类型
     * @return : List<TicketFieldDO> 自定义列List
     * @auther : LVDING
     * @date : 2018-07-26
     */
    @RequestMapping("getColumn")
    public @ResponseBody List<TicketFieldDO> getTicketColumn(@RequestParam String ticketType){
        List<TicketFieldDO> ticketFieldList = ticketFieldService.getColumn(ticketType);
        return ticketFieldList;
    }

    /**
     *
     * 功能描述 : 获得基础工单信息
     *
     * @param : String ticketType 工单类型
     * @return : List<TicketDTO> 基础工单List
     * @auther : LVDING
     * @date : 2018-07-26
     */
    @RequestMapping("getTicket")
    public @ResponseBody List<TicketDTO> getTicket(@RequestParam String ticketType){
        List<TicketDTO> ticketList = ticketService.getTicketList(ticketType);
        return ticketList;
    }

}