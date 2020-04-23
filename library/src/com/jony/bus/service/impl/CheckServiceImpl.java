package com.jony.bus.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jony.bus.domain.Book;
import com.jony.bus.domain.Check;
import com.jony.bus.domain.Customer;
import com.jony.bus.domain.Rent;
import com.jony.bus.mapper.BookMapper;
import com.jony.bus.mapper.CheckMapper;
import com.jony.bus.mapper.CustomerMapper;
import com.jony.bus.mapper.RentMapper;
import com.jony.bus.service.CheckService;
import com.jony.bus.vo.CheckVo;
import com.jony.sys.constast.SysConstast;
import com.jony.sys.domain.User;
import com.jony.sys.utils.DataGridView;
import com.jony.sys.utils.RandomUtils;
import com.jony.sys.utils.WebUtils;


@Service
public class CheckServiceImpl implements CheckService {

	@Autowired
	private CheckMapper checkMapper;
	@Autowired
	private CustomerMapper customerMapper;

	@Autowired
	private RentMapper rentMapper;
	@Autowired
	private BookMapper carMapper;
	@Override
	public Map<String, Object> initCheckFormData(String rentid) {
		
		//查询出租单
		Rent rent=this.rentMapper.selectByPrimaryKey(rentid);
		//查询客户
		Customer customer=this.customerMapper.selectByPrimaryKey(rent.getIdentity());
		//查询车辆
		Book car=this.carMapper.selectByPrimaryKey(rent.getCarnumber());
		//组装Check
		Check check=new Check();
		check.setCheckid(RandomUtils.createRandomStringUseTime(SysConstast.CAR_ORDER_JC));
		check.setRentid(rentid);
		check.setCheckdate(new Date());
		User user=(User) WebUtils.getHttpSession().getAttribute("user");
		check.setOpername(user.getRealname());
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("rent", rent);
		map.put("customer", customer);
		map.put("car", car);
		map.put("check", check);
		
		return map;
	}
	@Override
	public void addCheck(CheckVo checkVo) {
		this.checkMapper.insertSelective(checkVo);
		//更改出租单的状态
		Rent rent=this.rentMapper.selectByPrimaryKey(checkVo.getRentid());
		rent.setRentflag(SysConstast.RENT_BACK_TRUE);
		this.rentMapper.updateByPrimaryKeySelective(rent);
		//更改汽车的状态
		Book car=new Book();
		car.setCarnumber(rent.getCarnumber());
		car.setIsrenting(SysConstast.RENT_CAR_FALSE);
		this.carMapper.updateByPrimaryKeySelective(car);
	}
	@Override
	public DataGridView queryAllCheck(CheckVo checkVo) {
		Page<Object> page=PageHelper.startPage(checkVo.getPage(), checkVo.getLimit());
		List<Check> data = this.checkMapper.queryAllCheck(checkVo);
		return new DataGridView(page.getTotal(), data);
	}
	@Override
	public void updateCheck(CheckVo checkVo) {
		this.checkMapper.updateByPrimaryKeySelective(checkVo);
	}

}
