$(function () {
	//表格分页
    $('#queryList').DataTable({
    	"scrollX"	  : true,
  		'paging'      : true,
  	    'lengthChange': true,
  	    'searching'   : true,
  	    'ordering'    : true,
  	    'info'        : true,
  	    'autoWidth'   : false,
  	  	"pagingType"  : "full_numbers",
  	  	"pageLength"  : 10
    });
    //提示框
    $("[data-toggle='tooltip']").tooltip();

    
    //展开菜单
    $(".spreadSubm").click(function(){
    	var parentId = $(this).attr("data-id");
    	var text = $(this).find("font").text();
    	var el = $(this).parent().parent();
    	if("展开" == text){
    		$(this).find("font").text("折叠");
    		$.ajax({
				type:"POST",
		        url:_ctx+"/menu/getSubMenu",
		        data:{parent_id:parentId,time:new Date().getTime()},
		        dataType:"json",
		        cache:false,
		        success: function(data){
		       	 if("success" == data.status){
					showSubMeunList(data.data,el,parentId)
		       	 }else{
					alert(data.msg);
		       	 }
		        }
			})
    	}else{
    		$(this).find("font").text("展开");
    		$(".submenu"+parentId).remove();
    	}
    });
    order_id,
        senter,
        sent_address,
        collecter,
        collect_address,
        order_number,
        salesman_id,

    $("#submitBtn").click(function(){
    	var orderId = $("input[name='order_id']").val();
    	var senter = $("input[name='senter']").val();
    	var sentAddress = $("input[name='sent_address']").val();
    	var collecter = $("input[name='collecter']").val();
    	var collectAddress = $("input[name='collect_address']").val();
    	var orderNumber = $("[name='order_number']").val();
    	var salesmanId = $("input[name='salesman_id']").val();
    	$.ajax({
    		type:"POST",
    		url:actionUrl,
    		data:{orderId:order_id,senter:traffic_name,sentAddress:sent_address,collecter:collecter,collectAddress:collect_address,orderNumber:order_number,
                salesmanId:salesman_id},
    		dataType:"json",
    		cache:false,
    		success:function(data){
    			if(data.status == 'success'){
    				$("#queryModal").modal("hide");
    				//刷新
    				window.location.href=window.location.href;
    			}else{
    				alert(data.msg);
    			}
    		}
    	});
    });
  })

