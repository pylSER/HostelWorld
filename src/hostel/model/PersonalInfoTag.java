package hostel.model;

public class PersonalInfoTag {
	public String getInfoCard(MemberEntity me){
		String card="<div class=\"ui card\" style=\"margin-left: 50px;display: inline-block;margin-top: 20px\">    <div class=\"content\">        <div>            <span style=\"font-size: 30px\">会员信息</span>            <div style=\"float: right;font-size: 20px;cursor: pointer\" data-tooltip=\"编辑\" onclick=\"edit()\"><i class=\"edit icon\"></i></div>        </div>    </div>    <div class=\"content\">        <h4 class=\"ui sub header\">邮箱  <span style=\"margin-left: 15px\">;;email</span></h4>        <h4 class=\"ui sub header\">用户名  <span id=\"username\" style=\"margin-left: 15px\">;;name</span></h4>        <h4 class=\"ui sub header\">卡号  <span style=\"margin-left: 15px\">;;memid</span></h4>        <h4 class=\"ui sub header\">级别  <span style=\"margin-left: 15px\">;;level</span></h4>        <h4 class=\"ui sub header\">状态  <span style=\"margin-left: 15px\">;;state</span></h4>        <h4 class=\"ui sub header\">优惠  <span style=\"margin-left: 15px\">;;discount</span></h4>    </div>    <div class=\"extra content\">        <button class=\"ui ;;btncolor button\" style=\"width: 100%\" onclick=\";;action\">;;btntext</button>    </div></div>";
		String newcard=card.replaceAll(";;name",me.getUsername());
		
		
		String strmemid=""+me.getMemberid();
		String discount="所有预定"+getDiscount(me.getLevel())+"折";
		
		
		newcard=newcard.replaceAll(";;email",me.getEmail());
		newcard=newcard.replaceAll(";;memid",strmemid);
		
		
		String strlevel=me.getLevel()+"("+me.getOrdernum()+"/5)";
		
		newcard=newcard.replaceAll(";;level",strlevel);
		
		String state="使用中";
		String btncolor="red";
		String btntext="停用会员资格";
		String action="stop()";
		if(me.getState()==0){
			state="停用";
			btncolor="blue";
			btntext="启用会员资格";
			action="start()";
		}
		newcard=newcard.replaceAll(";;state",state);
		newcard=newcard.replaceAll(";;discount",discount);
		
		
		newcard=newcard.replaceAll(";;btncolor",btncolor);
		newcard=newcard.replaceAll(";;btntext",btntext);
		newcard=newcard.replaceAll(";;action",action);
		
		return newcard;
	}
	
	public String getBalanceCard(MemberEntity me){
		String card="<div class=\"ui card\" style=\"display: inline-block;width: 400px;vertical-align: top; margin-left: 20px;margin-top: 20px\">    <div class=\"content\">        <div>            <span style=\"font-size: 30px;margin-top: 5px\">余额</span>        </div>    </div>    <div class=\"content\">        <div class=\"ui statistic\" style=\"margin-top: 83px;margin-bottom: 83px;\">            <div class=\"value\">                ;;balance            </div>            <div class=\"label\">                RMB            </div>        </div>    </div>    <div class=\"extra content\">        <button class=\"ui primary button\" style=\"width: 100%\" onclick=\"charge()\">充值</button>    </div></div>";
		
		card=card.replaceAll(";;balance", me.getBalance()+"");
		
		return card;
	}
	
	public String getCoinCard(MemberEntity me){
		String card="<div class=\"ui card\" style=\"margin-left: 50px;display: inline-block\">    <div class=\"content\">        <div>            <span style=\"font-size: 30px;margin-top: 5px\">积分</span>            <span style=\"font-size: 15px;margin-top: 5px;float: right\">100积分=1元</span>        </div>    </div>    <div class=\"content\">        <div class=\"ui statistic\">            <div id=\"currCoinNum\" class=\"value\" style=\"margin-top: 16px;margin-bottom: 16px;\">                ;;coin            </div>        </div>    </div>    <div class=\"extra content\">        <button class=\"ui primary button\" style=\"width: 100%\" onclick=\"exchange()\">兑换积分</button>    </div></div>";
		
		card=card.replaceAll(";;coin",me.getCoin()+"");
		
		return card;
	}
	
	public String getCreditCard(MemberEntity me){
		String card="<div class=\"ui card\" style=\"width: 400px;display: inline-block;margin-left: 20px;\">    <div class=\"content\">        <div>            <span style=\"font-size: 30px;margin-top: 5px\">银行卡</span>        </div>    </div>    <div class=\"content\">        <div class=\"ui small horizontal statistic\">            <div class=\"label\">                卡号            </div>            <div id=\"creditNum\" class=\"value\" style=\"margin-left: 5px;margin-top: 30px;margin-bottom: 30px;\">                ;;creditcard            </div>        </div>    </div>    <div class=\"extra content\">        <button class=\"ui primary button\" style=\"width: 100%\" onclick=\"credit()\">修改卡号</button>    </div></div>";
		card=card.replaceAll(";;creditcard",me.getCreditid());
		return card;
	}

	private String getDiscount(int level){
		double discount=10;
		discount=discount-level*0.1;
		
		return discount+"";
	}
	
}
