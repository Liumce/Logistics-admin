//树 的配置，具体请看:http://www.treejs.cn/v3/main.php#_zTreeInfo
var setting = {
	check: {
		enable: true
	},
	data: {
		simpleData: {
			enable: true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: 0
		}
	}
};

//树 对象
function menuTree(id,pId,name,checked){
	this.id=id;
	this.pId=pId;
	this.name=name;
	this.checked=checked;
}

//权限处理
function orderMenu(oid,qx,title){
	var zNodes =[];
	reloadQXModal(oid,qx,title);
	$.ajax({
		type:"POST",
		url:_ctx+"/order/qx",
		cache:false,
		data:{time:new Date().getTime(),qx:qx,order_id:oid},
		dataType:"json",
		success:function(data){
			if(data.status == 'success'){
				var rultData = data.data;
				for(var i=0;i<rultData.length;i++){
					var childNode = [];
					var obj = rultData[i];
					zNodes.push(new menuTree(obj.menu_ID,obj.parent_ID,obj.menu_NAME,obj.hasMenu));
					if(obj.subMenu.length > 0){
						for(var j = 0;j<obj.subMenu.length;j++){
							var subm = obj.subMenu[j];
							zNodes.push(new menuTree(subm.menu_ID,subm.parent_ID,subm.menu_NAME,subm.hasMenu));
						}
					}
				}
				//初始化 数
				$.fn.zTree.init($("#orderTree"), setting,zNodes);
			}else{
				alert(data.msg);
			}
		}
	});
	$("#qxModal").modal("show");
}
$(function(){


	//点击模态框更改按钮
	$("#submit-smBtn").click(function(){

		var treeObj = $.fn.zTree.getZTreeObj("orderTree");
		var nodes = treeObj.getCheckedNodes(true);
		var ids = "";
		for(var i=0;i<nodes.length;i++){
			var node = nodes[i];
			if(i != nodes.length -1){
				ids =ids+node.id+",";
			}else{
				ids = ids +node.id;
			}
		}
		var orderId = $("input[name='order_id']").val();
		var qx = $("input[name='qx']").val();
		updateOrder(orderId,ids,qx)
	});

	
	//角色模态框的提交按钮
	$("#submit-orderId").click(function(){
		var url = $("input[name='url']").val();
		var orderId = $("input[name='order_id']").val();
		var senter = $("input[name='senter']").val();
		var senterPhone = $("input[name='senter_phone']").val();
		var sentAddress = $("input[name='sent_address']").val();
		var sentAddMsg = $("input[name='sent_addmsg']").val();
		var collecter = $("input[name='collecter']").val();
		var collectPhone = $("input[name='collect_phone']").val();
		var collectAddress = $("input[name='collect_address']").val();
		var collectAddMsg = $("input[name='collect_addmsg']").val();
		var weight = $("#weight").val();
		var note = $("#note").val();
		var salesmanId = $("input[name='salesman_id']").val();
		console.log("weigh:",weight);
		console.log("note:",note);
		// 这里是定义价格的
		var rate = 0;
		if(weight == '1'){
			rate = 10;
		}else if(weight == '2'){
			rate = 20;
		}else if(weight == '3'){
			rate = 30;
		}else{
			rate = 20;
		}
		var price = Number(weight)*rate;
		if(confirm("这个订单的价格为："+price+" ，你确定要保存订单吗？提交后请到系统帮助支付您的订单费用，谢谢!")){
            $.ajax({
                type:"POST",
                cache:false,
                url:_ctx+"/order/add",
                dataType:"json",
                data:{order_id:orderId,senter:senter,senter_phone:senterPhone,sent_address:sentAddress,
                    sent_addmsg:sentAddMsg,collecter:collecter,collect_phone:collectPhone,collect_address:collectAddress,
                    collect_addmsg:collectAddMsg,weight:weight,note:note,salesman_id:salesmanId,price:price},
                success:function(data){
                    if(data.status == 'success'){
                        window.location.href=window.location.href;
                        $("#orderModal").modal("hide");
                    }else{
                        alert(data.msg);
                    }
                }
            });
		}
	})
})