$(document).ready(function() {
    var finished = false;

    // 회원가입
    $('#join').on('click', function () {
        let data = {
            id : $('#joinId').val(),
            password : $('#joinPW').val(),
            name : $('#name').val()
        }

        // 테스트용
        $.ajax({
            data : data,
            type : 'post',
            url : 'rest/join',
            success : function () {
                alert('회원가입 완료');
                window.location.href = '/';
            }
        });

        /*
        이메일 인증 추가 후 사용
        if(finished == true) {
            $.ajax({
                data : data,
                type : 'post',
                url : 'rest/join',
                success : function () {
                    alert('회원가입 완료');
                    window.location.href = '/';
                }
            });
        }else {
            alert('이메일 인증을 완료해주세요.');
        }
        */
    });


    // 로그인
    $('#login').on('click', function() {
        let data = {
            id : $('#lodinId').val(),
            password : $('#loginPW').val()
        }

        $.ajax({
            data : data,
            type : 'post',
            url : '/rest/login',
            success : function () {
                window.location.href = '/';
            }
        });
    });

});