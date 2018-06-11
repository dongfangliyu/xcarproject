<html>
<head>
<title>借款协议</title>
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
.xhline {
	padding: 0 10px;
	border-bottom: #000 1px solid;
}
.shangfang {
	margin-right: 10px;
}
.gefang {
	display: inline-block;
	width: 148px;
	margin-right: 20px;
}
.h4t {
	font-weight: bold;
}
.lm30 {
	padding-left: 29px;
}
table {
	border-left: #000 1px solid;
	border-top: #000 1px solid;
}
td {
	border-right: #000 1px solid;
	border-bottom: #000 1px solid;
	padding: 0 10px;
	text-align: center;
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
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td>序号</td>
      <td>甲方（出借人）</td>
      <td>身份证号</td>
      <td>出借金额 /元</td>
    </tr>
     <#list investors as investors>
    <tr>
      <td>${investors.index}</td>
      <td>${investors.investorsName}</td>
      <td>${investors.investorsIc}</td>
      <td>${investors.ef_fective_amt}</td>
    </tr>
    </#list>
  </table><br />
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td>乙方（借款人）</td>
      <td>身份证号</td>
      <td>合计借款金额 /元</td>
    </tr>
    <tr>
			        <td>${map.custName}</td>
			        <td>${map.custIc}</td>
			        <td>${map.contracyMoney}</td>
	</tr>
  </table>
  <div class="h4t">第一条 借款信息</div>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="110">借款本金（人民币）</td>
      <td colspan="2">（小写）${map.contracyMoney}元</td>
      <td colspan="2">（大写）${map.contracyMoneyRMB}</td>
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
  <p>甲方委托支付机构自本协议签订日起三个工作日内将出借资金按照本协议约定扣划至乙方。</p>
  <div class="h4t">第二条 还款信息</div>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="110">还款期数</td>
      <td width="50">${map.periods}<span>期</span></td>
      <td>每期偿还本息数额</td>
      <td colspan="2">（小写）${contractinfo.monthMoney}元</td>
    </tr>
    <tr>
      <td>还款起止日期</td>
      <td colspan="2">${contractinfo.loadTime}~${contractinfo.finishTime}</td>
      <td>每期还款日</td>
      <td><b>详见还款提示函</b></td>
    </tr>
  </table>
  <p>（1）乙方保证在每期还款日前上述还款账户中余额不低于本条约定的每期偿还本息数额；</p>
  <p>（2）乙方委托支付机构每期从上述还款账户中准确划扣每期偿还本息数额给甲方； </p>
  <p>（3）如乙方提前还款或按本协议违约条款产生违约金，乙方委托支付机构从上述还款账户中扣划给甲方； </p>
  <p>（4）如还款日遇到法定节假日或公休日，则还款日不进行顺延；如当月无该日期，则还款日为当月最后一日；最后一期的还款日为借款到期日。 </p>

  <div class="h4t">第三条 提前还款</div>
  <p class="lm30">借款人至少提前三个工作日以书面方式提出，借款人应向出借人支付当月应还款和剩余全部本金。</p>
  <p class="lm30">提前还款的款项乙方亦委托支付机构代为划扣给甲方。</p>
  
  <div class="h4t">第四条 违约责任</div>
  
  <p>（1）还款日<div class="divUnderline" >　18　</div>点前，若第三方支付机构未能从本协议所列的借款人的专用银行卡中划取当期应还款项，则在本协议项下，视为逾期；</p>
  <p>（2）借款人逾期的，逾期款项中的借款本金部分自逾期之日起，每日支付合同本金的<div class="divUnderline" >　${contractinfo.interestRate}　</div>%作为违约金，直至清偿完毕之日止；</p>
  <p>（3）若乙方还款金额不足，则偿还顺序为逾期违约金、应还利息、应还本金；</p>
  <p>（4）因乙方违约而导致甲方产生的损失，包括本息损失、诉讼费用、调查费用、律师费用、差旅费用、上门催收费用<div class="divUnderline">（200元/次）</div>等由乙方</p>
  <p class="lm30">承担。</p>
  <div class="h4t">第五条 借款提前到期</div>
  <p>乙方有下列行为的，甲方可单方宣布借款提前到期；</p>
  <p>（1）乙方擅自改变借款用途的；</p>
  <p><b>（2）严重违反还款义务：逾期达到<div class="divUnderline" >　2期　</div>及以上的；</b></p>
  <p><b>（3）居间服务方发现借款人有较大还款风险，包括且不仅限于还款意愿、还款能力发生恶化等情形。</b></p>
  <div class="h4t">第六条 通知</div>
  <p>（1）各方同意并确认，若出借人转让其借款债权的，出借人或出借人委托平台将《债权转让通知》以邮件的方式发送至乙方下列邮箱</p>
  <p class="lm30"><span class="xhline">${map.email}</span>或将《债权转让通知》以站内信方式发送至乙方在苏州中资联投资管理有限公司平台的会员收件箱。</p>
  <p class="lm30">该通知自甲方发送后，相关债权转让即对借款人发生法律效力。乙方应向债权受让人继续履行本协议的后续还款义务；</p>
  <p><b>（2）诉讼送达地址：以乙方预留的地址作为送达地址，该地址经邮寄后，发出7日内视为送达成功。</b></p>
  <p class="lm30"><b>送达地址为<span class="xhline">${map.icAddress}</span>。</b></p>

  <div class="h4t">第七条 证据和计算</div>
  <p style="text-indent:2em">本协议各方确认并同意，委托苏州中资联投资管理有限公司对本协议项下的任何金额进行计算；在无明显错误的情况下，苏州中资联投资管</p>
  <p class="lm30">理有限公司对本协议项下任何金额的任何证明或确定，应作为该金额有关事项的终局证明。</p>
  <div class="h4t">第八条 法律适用及争议管辖</div>
  <p>（1）本协议项下全部事项，包括但不限于本协议的效力、解释、履行及争议的解决均受中国法律管辖；本协议项下任一条款如有与中国法律中</p>
  <p class="lm30">的强制性规范相抵触，应在该等强制性规范所不受禁止的最大限度内进行解释和执行，且任何该等与强制性规范相抵触的约定不应影响本</p>
  <p class="lm30">协议其他条款的效力；</p>
  <p>（2）本协议中部分条款根据相关法律法规等的规定成为无效，或部分无效时，该等无效不影响本协议项下其他条款的效力，各方仍应履行其在</p>
  <p class="lm30">本协议项下的义务；</p>
  <p>（3）凡因本合同引起的或与本合同有关的任何争议，均应提交<div class="divUnderline">　上海仲裁委员会　</div>按照该会仲裁规则进行仲裁。</p>
  <p class="lm30">仲裁裁决是终局的，对双方当事人均有约束力。</p>
  <div class="h4t">第九条 其他</div>
  <p>（1）本协议自甲乙双方签订时成立，自甲方将出借款项支付到乙方账户时生效；</p>
  <p>（2）本协议项下各方同意并承诺，本协议项下各方提供的信息均应在提供给本协议其他居间方的同时提供给苏州中资联投资管理有限公司提供</p>
  <p class="lm30">的所有信息；</p>
  <p>（3）本协议的任何修改、补充、变更均需以书面(含电子协议)形式签订；</p>
  <p><b>（4）甲方同意，如果乙方逾期还款达到<div class="divUnderline">　3期　</div>，则甲方的债权自动无偿转让给苏州中资联信用管理有限公司，苏州中资联信用管理有限公司</b></p>
  <p class="lm30"><b>有权以自己的名义直接向乙方主张债权，乙方对此条款理解无误；</b></p>
  <p>（5）本协议的传真件、复印件和影印件等复本的效力与本协议原件具有同等法律效力。</p>
  <p>（以下无正文）</p>
  <br />
  <p>乙方（借款人）　　　　　　　　　　　　　　　　　　　　　　　　</p>
  <p>签署日期：　　　　　　　　　　　　　　　　　　　　　　　　　　</p>
  <br />
  <p>甲方（出借人）　　　　　　　　　　　　　　　　　　　　　　　　</p>
  <p>签署日期：　　　　　　　　　　　　　　　　　　　　　　　　　　</p>
  <#if (contractinfo.caChannel == '000023-0002' && investors?size > 15)>
  	<div style="page-break-before:always;">
  	　
  	</div>
  <#elseif  (contractinfo.caChannel == '000023-0001' && investors?size > 12 && investors?size < 20)>
  	<div style="page-break-before:always;">
  	　
  	</div>
  </#if>
    <div style="page-break-before:always;">
    	<p>附件1：</p>
	    <div class="h2t">催收授权委托书</div><br /><br />
	    <p>兹因本人出借款项给借款人，现借款人未能按期偿还约定的款项，故本人委托苏州中资联信用管理有限公司及其委托人予以处理。</p><br />
	    <p>授权范围：</p><br />
	    <p>1.代为确认款项金额，代为收款到受托人指定账户；</p><br />
	    <p>2.代为签订和解协议，代为协调处理，采取诉讼、催要等合法方式催讨该款项。</p><br />
	    <p><b>该授权事项可以由苏州中资联信用管理有限公司转委托给他人行使。</b></p><br />
	    <p>本人对上述委托行为予以认可！</p><br /><br /><br />
	    <p>委托人：</p>
	</div>
</div>
</body>
</html>
