
//编辑接单员信息
function editTransfer(order_id,salesman_id){
    // console.log(order_id+","+salesman_id+",");
    reloadModelData(_ctx+"/transfer/add","编辑接单信息","更新",order_id,"",salesman_id,"","edit");
    $("#transferModal").modal("show");
}

//修改模态框的数据
function reloadQXModal(orderId,qx,salesmanId,title){
    $("input[name='qx']").val(qx);
    $("input[name='order_id']").val(orderId);
    $("input[name='salesman_id']").val(salesmanId);
    $("#modelHead").text(title);
}


//
$(function () {
    //表格分页
    $('#transferList').DataTable({
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
    // //接单
    // $("#likes").click(function () {
    //     var salesmanId = $("input[name='salesman_id']").val();
    //     $.ajax({
    //         type:"POST",
    //         url:actionUrl,
    //         data:{salesmanId:salesman_id},
    //         dataType:"json",
    //         cache:false,
    //         success:function(data){
    //             if(data.status == 'success'){
    //                 $("#transferModal").modal("hide");
    //                 //刷新
    //                 window.location.href=window.location.href;
    //             }else{
    //                 alert(data.msg);
    //             }
    //         }
    //     });
    // });

    $("#submit-roleBtn").click(function(){
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
        var weight = $("input[name='weight']").val();
        var note = $("input[name='note']").val();
        var salesmanId = $("input[name='salesman_id']").val();
        alert("actionUrl="+actionUrl);
        $.ajax({
            type:"POST",
            url:actionUrl,
            data:{order_id:orderId,senter:senter,senter_phone:senterPhone,sent_address:sentAddress,
                sent_addmsg:sentAddMsg,collecter:collecter,collect_phone:collectPhone,collect_address:collectAddress,
                collect_addmsg:collectAddMsg,weight:weight,note:note,salesmanId:salesman_id},
            dataType:"json",
            cache:false,
            success:function(data){
                if(data.status == 'success'){
                    $("#transferModal").modal("hide");
                    //刷新
                    window.location.href=window.location.href;
                }else{
                    alert(data.msg);
                }
            }
        });
    });
})

