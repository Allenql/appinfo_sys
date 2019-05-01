
$(document).ready(function(){
    var img=Array("adver01.jpg","adver02.jpg","adver03.jpg","adver04.jpg","adver05.jpg","adver06.jpg");
    var flag=0;
    $(".arrowRight").click(function(){
        if(flag==img.length-1){alert("已经是最后一张图片了");}
        else{
            flag++;
            var i=flag+1;
            $(".adver").css("background","url(/statics/images/"+img[flag]+")");
            $("li:nth-of-type("+i+")").css("background","orange");
            $("li:nth-of-type("+i+")").siblings().css("background","#333333");
        }
    });

    $(".arrowLeft").click(function(){
        if(flag==0){alert("这是第一张图片了");}
        else{
            flag--;
            var i=flag+1;
            $(".adver").css("background","url(/statics/images/"+img[flag]+")");
            $("li:nth-of-type("+i+")").css("background","orange");
            $("li:nth-of-type("+i+")").siblings().css("background","#333333");
        }
    });
    $(".adver").mouseover(function(){
        $(".arrowRight").show();
        $(".arrowLeft").show();
    }).mouseout(function(){
        $(".arrowRight").hide();
        $(".arrowLeft").hide();
    })
})