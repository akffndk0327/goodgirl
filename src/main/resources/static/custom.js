//로그인 버튼 - > id 찾아서 1명의 정보 가져오고 화면 넘어가
$("#login").click(function () {
    var id = $("#loginid").val();
    var pwd = $("#loginpwds").val();

    if (id == null || id == "") {
        alert("아이디를 입력해주세요");
    } else if (pwd == null || pwd == "") {
        alert("비밀번호를 입력해주세요");

    }

    var data = $('#login_form').serializeObject()
    console.log(data);

    $.ajax({
        url: "/loginChk",
        data: JSON.stringify(data),
        method: "post",
        dataType: "text",
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            alert(id + "님 환영합니다.");
            location.href = "/login"  // login 화면으로 넘어감
        }
    })
    .fail(function (r) {
        var message = JSON.parse(r.responseText);
        alert('서버 오류');
    })
})


//메인 회원가입 버튼 -> 화면 넘어가
$("#sign").click(function () {
    location.href = "/signUpPre"
})

function checkedAll() {
    //체크박스 전체 선택 & 해제
    $(".terms_p").on("click", '#chk_all', function () {
        var checked = $(this).is(":checked");

        if (checked) {
            $(this).parents(".terms_p").find('input').prop("checked", true);
        } else {
            $(this).parents(".terms_p").find('input').prop("checked", false);
        }
    })

    // 체크박스 개별 선택
    $(".terms_p").on("click", ".chk", function () {
        var checked = $(this).is(":checked");

        $(".chk").each(function () {
            checked = checked && $(this).is(":checked");
        });

        $("#chk_all").prop("checked", checked);
    });

}


$("#btnAgree").click(function () {
    //약관 동의 체크 사항 확인
    if ($("#termsService").is(":checked") == false) {
        alert("이용약관 동의 체크를 해주세요");
        return false;
    }
    if ($("#termsPrivacy").is(":checked") == false) {
        alert("개인정보 수집 및 이용 동의 체크를 해주세요");
        return false;
    }
    $("#join_form").submit();
    return true;

})

//form 체크
function chkform() {
    var id = $("#id").val();

    var pswd1 = $("#pswd1").val();
    var pswd2 = $("#pswd2").val();
    var regExp = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{5,12}$/

    var name = $("#name").val();
    var inputAddress = $("#inputAddress").val();
    var email = $("#email").val();
    var inputbirth = $("#inputbirth").val();
    var inputgender = $("#inputgender").val();
    var inputnum = $("#inputnum").val();

    if (id == '' || id == null) {
        alert("아이디를 입력해주세요");
        return false;
    }
    if (pswd1 == '' || pswd1 == null) {
        alert("비밀번호를 입력해주세요");
        return false;
    } else if (regExp.test(pswd1) == false) {
        alert('비밀번호는 5자이상 12자 이하, 숫자/대문자/소문자/특수문자를 포함해야 합니다.');
        return false;
    } else if (pswd2 == '' || pswd2 == null) {
        alert("비밀번호 재확인을 입력해주세요");
        return false;
    } else if (!(pswd2 == pswd1)) {
        alert("비밀번호를 다시 확인해주세요");
        return false;
    }
    if (name == '' || name == null) {
        alert("이름을 입력해주세요");
        return false;
    } else if (inputAddress == '' || inputAddress == null) {
        alert("주소를 입력해주세요");
        return false;
    } else if (email == '' || email == null) {
        alert("이메일을 입력해주세요");
        return false;
    } else if (inputbirth == '' || inputbirth == null) {
        alert("생년월일을 입력해주세요");
        return false;
    } else if (inputgender == '' || inputgender == null) {
        alert("성별을 입력해주세요");
        return false;
    } else if (inputnum == '' || inputnum == null) {
        alert("전화번호를 입력해주세요");
        return false;
    } else if ($("#gridCheck").is(":checked") == false) {
        alert("check me out을 체크해주세요 ");
        return false;
    }
    return true;
}

jQuery.fn.serializeObject = function () {
    var obj = null;
    try {
        if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
            var arr = this.serializeArray();
            if (arr) {
                obj = {};
                jQuery.each(arr, function () {
                    obj[this.name] = this.value;
                });
            }
        }
    } catch (e) {
        alert(e.message);
    } finally {
    }
    return obj;
}

//회원가입버튼
$("#btnJoin").click(function () {
    if (chkform()) {
        $("#join_form").submit();
    }
})


//ajax버튼으로 data 날리기
$("#btnAjax").click(function () {

    var data = $('#join_form').serializeObject()

    console.log(data);

    $.ajax({
        type: 'POST',
        url: '/signChk',
        data: JSON.stringify(data), //form 데이터 json

        //serialize 사용 안하는 경우
        // data :{
        //     "aa" : aa, "bb" : bb
        // },

        contentType: 'application/json;charset=UTF-8',
        dataType: 'text',
        success: function (data) {
            alert(data);
            location.href = "/";
        }
    }).fail(function (r) {
        var message = JSON.parse(r.responseText);
        alert('서버 오류');
    })

})

//login 후- 고객정보수정하기
function update(){


}


// $("#btn_content2").click(function () {
//     var content1 = $("#content1").val(); //내용1 값을 가져오고
//
//     var content2 = $("#content2").val(); //내용2값 가져오기
//
//     if(content2 != content1){
//         $("#content2").val(content1);
//     }
//
//     var content3 = $("#content3").val(); //내용3값 가져오기
//
//     var textarea = $("#floatingTextarea").val(content1+content2+content3); //
//
// });


// Swal.fire({
//     icon: 'success',
//     title: 'Alert가 실행되었습니다.',
//     text: '이곳은 내용이 나타나는 곳입니다.',
// });