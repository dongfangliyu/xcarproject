<html >
<head>
 <style>
* {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 10.5px;
	line-height: 22px;
}
     body {  
         font-family: SimSun;  
     }
.wrap {
	width: 660px;
	margin: 0 auto;
}
p {
	text-align: justify;
	text-justify: inter-ideograph;
}
.h2t {
	font-size: 18px;
	font-weight: bold;
	text-align: center;
}
.xybh {
	text-align: right;
}
.picture{
    width: 80px;
    height: 110px;
    float: right;
    margin-right: 80px;
    border: 1px solid #000;
    text-align: center;
    line-height: 110px;
}
.xhline {
	padding: 0 10px;
	border-bottom: #000 1px solid;
}
.shangfang{margin-right:10px;}
.gefang{ display:inline-block; width:180px; margin-right:20px;}
.h4t {
	font-weight: bold;
}
.lm30 {
	padding-left: 29px;
}
table {
    		 width:100%;border:#000 dotted ;border-width:0 0 0 0;
    		 border-collapse:collapse;
    		 
     }
     td {
    		 border:#000 solid;border-width:1px;
     }
.divUnderline{
	text-decoration:underline;
	display:inline-block;
	width:auto;
}     
@page {
            size: 8.5in 11in;
            @bottom-center {
            	font-family :SimSun;
                content: " 第 " counter(page) " 页 ，共 " counter(pages)" 页 ";
            }
        }
        #pagenumber:before {
            content: counter(page);
        }
</style>
</head>
<body>
<div class="wrap"> 
  <br />
  <div class="h2t">借款协议</div>
  <div class="xybh">协议编号：<span class="xhline">${contractPrimaryKey}</span></div>
  <div class="picture">
 <img src="${(picture.pictureName)!}"  height="110px" width="80px"/>
  </div>
  <#list investors as investors>
  <p>甲方（出借人）：<span class="xhline shangfang">${investors.investorsName}</span>身份证号码：<span class="xhline shangfang">${investors.investorsIc}</span></p>
  </#list>
  
  <p>乙方（借款人）：<span class="xhline shangfang">${map.custName}</span>身份证号码：<span class="xhline shangfang">${map.custIc}</span></p>
  
  <div class="h4t" style='margin-top: 60px;'>第一条 借款信息</div>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="110">借款本金（人民币）</td>
      <td colspan="2">${map.contracyMoney}元</td>
      <td colspan="2">${map.contracyMoneyRMB}</td>
    </tr>
    <tr>
      <td>借款年利率</td>
      <td width="50">${map.invest_rate}%</td>
      <td width="80">借款用途</td>
      <td colspan="2">${map.repayment_purpose}</td>
    </tr>
   
    <tr>
      <td rowspan="2">借款人收款账户</td>
      <td>开户行</td>
      <td colspan="3">${map.borrowerBank}</td>
    </tr>
    <tr>
      <td>户名</td>
      <td>${map.borrowerAccount}</td>
      <td width="30">帐号</td>
      <td>${map.borrowerCard}</td>
    </tr>
   
  </table>
  <p style="text-align:center;">甲方委托支付机构自本协议签订日起三个工作日内将出借资金按照本协议约定扣划至乙方。</p>
  <div class="h4t">第二条 还款信息</div>
  <#list investors as investors>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="110">还款分期月数</td>
      <td width="50">${map.periods}<span>月</span></td>
      <td>每月月偿还本息数额</td>
      <td colspan="2">${contractinfo.monthMoney}元</td>
    </tr>
    <tr>
      <td>还款起止日期</td>
      <td colspan="2">${contractinfo.loadTime}~${contractinfo.finishTime}</td>
      <td>每月还款日</td>
      <td>详见附件1</td>
    </tr>
    <tr>
      <td rowspan="2">出借人收款账户</td>
      <td>开户行</td>
      <td colspan="3"> <#if (investors.borrowerBank) == "null">
   &#160;
  <#else>
   ${investors.borrowerBank}
  </#if></td>
    </tr>
    <tr>
     <td>户名</td>
      <td>${investors.borrowerAccount}</td>
      <td width="30">帐号</td>
      <td>${investors.borrowerCard}</td>
    </tr>
  </table>
  </#list>
  <br />
  <p>（1）乙方保证在每月还款日前上述还款账户中余额不低于本条约定的月偿还本息数额；</p>
  <p>（2）乙方委托支付机构每月从上述还款账户中准确划扣月偿还本息数额给甲方； </p>
  <p>（3）如乙方提前还款或按本协议违约条款产生违约金，乙方委托支付机构从上述还款账户中扣划给甲方； </p>
  <p>（4）如还款日遇到法定节假日或公休日，则还款日不进行顺延；如当月无该日期，则还款日为当月最后一日；最后一期的还款日为借款到期日。</p>

  <div class="h4t">第三条 提前还款</div>
  <p style="text-indent:2em">借款人至少提前三个工作日以书面方式提出，借款人应向出借人支付当月应还款和剩余全部本金，同时向出借人支付提前还款违约金，
  支付规则如下：</p>
  <p>（1）在 ${contractinfo.peroidFirst} 个月内提前还款，则退还剩余服务费与风险拨备金，违约金为合同金额的${contractinfo.peroidFirstRate};</p>
  <p>（2）在 ${contractinfo.peroidSecondStart}-${contractinfo.peroidSecondEnd} 个月内提前还款，则退还剩余服务费与风险拨备金，违约金为合同金额的${contractinfo.peroidSecondRate};</p>
  <p>（3）在 ${contractinfo.peroidThird}（含）个月及以上提前还款，则退还剩余服务费与风险拨备金，违约金为合同金额的${contractinfo.peroidThirdRate};</p>
  <p style="text-indent:2em">提前还款的款项乙方亦委托支付机构代为划扣给甲方。</p>
  
  <div class="h4t">第四条 违约责任</div>
  
  <p>（1）还款日18点前，若第三方支付机构未能从本协议所列的借款人的专用银行卡中划取当期应还款项，则在本协议项下，视为逾期。</p>
  <p>（2）借款人逾期的，逾期款项中的借款本金部分自逾期之日起，每日支付合同本金的   0.1 %作为违约金，直至清偿完毕之日止。</p>
  <p>（3）若乙方还款金额不足，则偿还顺序为逾期违约金、应还利息、应还本金。</p>
  <p>（4）因乙方违约而导致甲方产生的损失，包括本息损失、诉讼费用、调查费用、律师费用、差旅费用、上门催收费用（200元/次）等由乙方承担。</p>
  <div class="h4t">第五条 借款提前到期</div>
  <p>乙方有下列行为的，甲方可单方宣布借款提前到期。</p>
  <p>（1）乙方擅自改变借款用途的。</p>
  <p>（2）严重违反还款义务（逾期达到15天以上的）。</p>
  
  <div class="h4t">第六条 通知</div>
  <p>（1）各方同意并确认，若出借人转让其借款债权的，出借人或出借人委托平台将《债权转让通知》以邮件</p>
  <p class="lm30">的方式发送至乙方下列邮箱<span class="xhline">
  <#if (map.email) == "null">
   &#160;
  <#else>
   ${map.email}
   </#if></span>或将《债权转让通知》以站内信方式发送至乙方在</p>
  <p class="lm30">苏州东方信泰金融信息服务有限公司平台的会员收件箱。 该通知自甲方发送后，相关债权转让即对借款人发生法律效力。</p>
  <p class="lm30">乙方应向债权受让人继续履行本协议的后续还款义务。</p>
  <p>（2）诉讼送达地址：以乙方预留的地址作为送达地址，该地址经邮寄后，发出7日内视为送达成功。</p>
  <p class="lm30">送达地址为<span class="xhline">
  <#if (map.icAddress) == "null">
   &#160;
  <#else>
   ${map.icAddress}
  </#if></span></p>

  <div class="h4t">第七条 证据和计算</div>
  <p style="text-indent:2em">本协议各方确认并同意，委托苏州东方信泰金融信息服务有限公司对本协议项下的任何金额进行计算；在无明显错误的情况下，</p>
  <p> 苏州东方信泰金融信息服务有限公司对本协议项下任何金额的任何证明或确定，应作为该金额有关事项的终局证明。</p>
  <div class="h4t">第八条 法律适用及争议管辖</div>
  <p>（1）本协议项下全部事项，包括但不限于本协议的效力、解释、履行及争议的解决均受中国法律管辖；本</p>
  <p class="lm30">协议项下任一条款如有与中国法律中的强制性规范相抵触，应在该等强制性规范所不受禁止的最大</p>
  <p class="lm30">限度内进行解释和执行，且任何该等与强制性规范相抵触的约定不应影响本协议其他条款的效力。</p>
  <p>（2）本协议中部分条款根据相关法律法规等的规定成为无效，或部分无效时，该等无效不影响本协议项下</p>
  <p class="lm30">其他条款的效力，各方仍应履行其在本协议项下的义务。</p>
  <p>（3）凡因本合同引起的或与本合同有关的任何争议，均应提交上海仲裁委员会按照该会仲裁规则进行仲</p>
  <p class="lm30">裁。仲裁裁决是终局的，对双方当事人均有约束力。</p>
  <div class="h4t">第九条 其他</div>
  <p>（1）本协议自甲乙双方签订时成立，自甲方将出借款项支付到乙方账户时生效。</p>
  <p>（2）本协议项下各方同意并承诺，本协议项下各方提供的信息均应在提供给本协议其他居间方的同时提供</p>
  <p class="lm30">给苏州东方信泰金融信息服务有限公司提供的所有信息。</p>
  <p>（3）本协议的任何修改、补充、变更均需以书面(含电子协议)形式签订。</p>
  <p>（4）甲方同意，如果乙方逾期还款达到30天，则甲方的债权自动无偿转让给苏州东方信泰金融信息服务有限公司</p>
  <p class="lm30">，苏州东方信泰金融信息服务有限公司有权以自己的名义直接向乙方主张债权，乙方对此条款理解无误。</p>
  <p>（5）本协议的传真件、复印件和影印件等复本的效力与本协议原件具有同等法律效力。</p>
  <p>附件1：《还款明细提示函》；</p>
  <p>（以下无正文）</p>
  <br />
  <p>甲方（出借人）<span class="xhline gefang"></span>乙方（借款人）<span class="xhline gefang"></span></p>
  <br />
  <p>签署日期：<span class="xhline gefang"></span>签署日期：<span class="xhline gefang"></span></p>
     
    <br /><br /><br /><br /><!-- <br /><br /><br /><br /> -->
    <div style="page-break-before:always;">
    <div class="h2t">还款提示函</div>
  <p><span class="xhline shangfang">${map.custName}</span>先生/女士 您好：</p>
  <p>您的借款合同金额：<span class="xhline gefang">${map.contracyMoney}元</span></p>
  <p>您的收（还）款账户开户银行（精确到支行）：<span class="xhline gefang">${map.borrowerBank}</span></p>
  <p>您的收（还）款账户名：<span class="xhline gefang">${map.cust_nm}</span></p>
  <p>您的收（还）款账户账号：<span class="xhline gefang">${map.capAcntNo}</span></p>
  <p class="mt20">友情提示： </p>
  <p>为了延续您良好的信用记录，请在每期还款日前一天检查确认当期应还款项已经存入还款账户，并仔细阅读以下几条，谢谢配
  台。</p>
  <p>1.请您签署借款合同时，清楚的了解产品费率、逾期罚息以及还款时间等各项信息，并承诺所有信息均为本人提供，且真实有效；</p>
  <p><b>2.本公司在整个贷款过程中，除了合同约定金额，不会向客户收取额外费用；</b></p>
  <p><b>3.本公司在整个贷款过程中，不会向客户承诺合同以外的条约；</b></p>
  <p>4.为保障您能正常的还款，同时积累良好的信用记录，我们会在每个还款日前一天用短信或电话的形式提醒您，您需在还款日
  前将还款金额足额存入到约定的借记卡内；</p>
  <p>5.请您按照借款协议约定的还款金额及期限，按时偿还借款本息。若您未及时足额还款，将根据借款协议按日收取违约金及罚
  息，同时造成工作人员上门追讨，产生的上门费用200元/次将由您承担；</p>
  <p>6.提前全部还款：如果您决定提前全部结清借款，请务必按借款协议要求提前3个工作日联系相关工作人员，按要求办理提前还
  款手续，提前结清时应退的相关费用在还款金额中抵扣；</p>
  <p><b>7.本司全国联系热线：400-0686-600；</b></p>
  <p><b>请您谨防不法人员冒用本司工作人员名义或联系方式行骗；</b></p>
  <p>8.您的每个还款日及还款金额，请见下表；</p>
  <table class="fjtab">
  		<tr>
        	<th>期数</th>
            <th>日期</th>
            <th>本期应还本金(元)</th>
            <th>本期应还利息(元)</th>
            <th>本期应还总额(元)</th>
            <th>期末剩余本金(元)</th>
            <th>本期提前结清应还总额(元)</th>
        </tr>
        <#list list as being>
			    <tr>
			     <td style="text-align:center;">${being.qishu}</td>
			        <td>${being.time}</td>
			        <td style="text-align:right;padding-right:8px;box-sizing:border-box;">${being.capiital}</td>
			        <td style="text-align:right;padding-right:8px;box-sizing:border-box;">${being.accral}</td>
			        <td style="text-align:right;padding-right:8px;box-sizing:border-box;">${being.money}</td>
			        <td style="text-align:right;padding-right:8px;box-sizing:border-box;">${being.remainAllMoney}</td>
			        <td style="text-align:right;padding-right:8px;box-sizing:border-box;">${being.advanceMoney}</td>
			    </tr>
		</#list>
  </table>
  <br/>
  <div class="fr">借款人：<span class="xhline1"></span></div>
  
  </div>
</div>
</body>
</html>
