package cn.itcast.shop.order.action;

import java.io.IOException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import cn.itcast.shop.cart.vo.Cart;
import cn.itcast.shop.cart.vo.CartItem;
import cn.itcast.shop.order.service.OrderService;
import cn.itcast.shop.order.vo.Order;
import cn.itcast.shop.order.vo.OrderItem;
import cn.itcast.shop.user.vo.User;
import cn.itcast.shop.utils.PageBean;
import cn.itcast.shop.utils.PaymentUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 璁㈠崟Action绫�
 * 
 * @author 浼犳櫤.閮槈
 * 
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	// 妯″瀷椹卞姩浣跨敤鐨勫璞�
	private Order order = new Order();

	public Order getModel() {
		return order;
	}

	// 鎺ユ敹鏀粯閫氶亾缂栫爜:
	private String pd_FrpId;

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}
	// 鎺ユ敹浠樻鎴愬姛鍚庣殑鍙傛暟:
	private String r3_Amt;
	private String r6_Order;
	
	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}

	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}

	// 鎺ユ敹page
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// 娉ㄥ叆OrderService
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	// 鐢熸垚璁㈠崟鐨勬墽琛岀殑鏂规硶:
	public String saveOrder() {

		order.setOrdertime(new Date());
		order.setState(1);
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			this.addActionMessage("浜�!鎮ㄨ繕娌℃湁璐墿!");
			return "msg";
		}
		order.setTotal(cart.getTotal());
		
		for (CartItem cartItem : cart.getCartItems()) {
			// 璁㈠崟椤圭殑淇℃伅浠庤喘鐗╅」鑾峰緱鐨�.
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);

			order.getOrderItems().add(orderItem);
		}
		
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
           System.out.println(existUser+"..............................");
		order.setUser(existUser);
	
	
		orderService.save(order);

		cart.clearCart();

		// 椤甸潰闇�瑕佸洖鏄捐鍗曚俊鎭�:
		// 浣跨敤妯″瀷椹卞姩浜� 鎵�鏈夊彲浠ヤ笉浣跨敤鍊兼爤淇濆瓨浜�
		// ActionContext.getContext().getValueStack().set("order", order);

		return "saveOrder";
	}

	// 鏌ヨ鎴戠殑璁㈠崟:
	public String findByUid() {
		// 鑾峰緱鐢ㄦ埛鐨刬d.
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		// 鑾峰緱鐢ㄦ埛鐨刬d
		Integer uid = existUser.getUid();
		// 鏍规嵁鐢ㄦ埛鐨刬d鏌ヨ璁㈠崟:
		PageBean<Order> pageBean = orderService.findByUid(uid, page);
		// 灏哖ageBean鏁版嵁甯﹀埌椤甸潰涓�.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByUid";
	}

	// 鏍规嵁璁㈠崟id鏌ヨ璁㈠崟:
	public String findByOid() {
		order = orderService.findByOid(order.getOid());
		return "findByOid";
	}

	// 涓鸿鍗曚粯娆�:
	public String payOrder() throws IOException {
		// 1.淇敼鏁版嵁:
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setAddr(order.getAddr());
		currOrder.setName(order.getName());
		currOrder.setPhone(order.getPhone());
		// 淇敼璁㈠崟
		orderService.update(currOrder);
		// 2.瀹屾垚浠樻:
		// 浠樻闇�瑕佺殑鍙傛暟:
		String p0_Cmd = "Buy"; // 涓氬姟绫诲瀷:
		String p1_MerId = "10001126856";// 鍟嗘埛缂栧彿:
		String p2_Order = order.getOid().toString();// 璁㈠崟缂栧彿:
		String p3_Amt = "0.01"; // 浠樻閲戦:
		String p4_Cur = "CNY"; // 浜ゆ槗甯佺:
		String p5_Pid = ""; // 鍟嗗搧鍚嶇О:
		String p6_Pcat = ""; // 鍟嗗搧绉嶇被:
		String p7_Pdesc = ""; // 鍟嗗搧鎻忚堪:
		String p8_Url = "http://192.168.0.17:8080/shop/order_callBack.action"; // 鍟嗘埛鎺ユ敹鏀粯鎴愬姛鏁版嵁鐨勫湴鍧�:
		String p9_SAF = ""; // 閫佽揣鍦板潃:
		String pa_MP = ""; // 鍟嗘埛鎵╁睍淇℃伅:
		String pd_FrpId = this.pd_FrpId;// 鏀粯閫氶亾缂栫爜:
		String pr_NeedResponse = "1"; // 搴旂瓟鏈哄埗:
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 绉橀挜
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue); // hmac
		// 鍚戞槗瀹濆彂閫佽姹�:
		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		
		// 閲嶅畾鍚�:鍚戞槗瀹濆嚭鍙�:
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
	}

	// 浠樻鎴愬姛鍚庤烦杞洖鏉ョ殑璺緞:
	public String callBack(){
		// 淇敼璁㈠崟鐨勭姸鎬�:
		Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
		// 淇敼璁㈠崟鐘舵�佷负2:宸茬粡浠樻:
		currOrder.setState(2);
		orderService.update(currOrder);
		this.addActionMessage("鏀粯鎴愬姛!璁㈠崟缂栧彿涓�: "+r6_Order +" 浠樻閲戦涓�: "+r3_Amt);
		return "msg";
	}
	
	// 淇敼璁㈠崟鐨勭姸鎬�:
	public String updateState(){
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setState(4);
		orderService.update(currOrder);
		return "updateStateSuccess";
	}
}
