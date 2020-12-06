$(document).ready(function() {
    console.log('JS 연결 완료');
    var finished = false;

    // 회원가입
    $('#join').on('click', function () {
        let data = {
            id : $('#joinId').val(),
            password : $('#joinPW').val(),
            name : $('#name').val(),
            email : $('#joinEmail').val(),
            rePw : $('#repeatJoinPw').val()
        }

        if(data.rePw === data.password){
            alert('비밀번호 확인 값이 일치하지 않습니다.');
            return;
        }

        if(finished === true) {
            $.ajax({
                data : data,
                type : 'post',
                url : 'rest/join',
                success : function () {
                    alert('회원가입 완료');
                    window.location.href = '/index';
                }
            });
        }else {
            alert('이메일 인증을 완료해주세요.');
        }
    });

    // 로그인
    $('#login').on('click', function () {


        let data = {
            id: $('#inputLogin').val(),
            password: $('#inputPassword').val()
        }

        if(data.id === '' || data.password === ''){
            alert('입력값을 확인해주세요.');
            return;
        }

        $.ajax({
            data : data,
            type : 'post',
            url : '/rest/login',
            success : function (verify) {
                if(verify === 1){
                    alert('로그인 성공');
                    window.location.href = '/index';
                }else {
                    alert('로그인 실패');
                }
            }
        });
    });

    // 메일 전송
    $('#sendEmail').on('click', function() {
        let data = {
            userEmail : $('#joinEmail').val()
        }

        if(data.userEmail === ''){
            alert('이메일을 입력해주세요');
            return;
        }

        $.ajax({
            data : data,
            type : 'post',
            url : 'rest/email',
            success : function() {
                alert('전송 완료');
            }
        });
    });

    // 인증코드 전송
    $('#confirm').on('click', function() {
        let data = {
            confirm : $('#confirmCode').val()
        }

        $.ajax({
            data : data,
            type : 'post',
            url : '/rest/confirm',
            success : function(verify) {
                if(verify === 1){
                    finished = true;
                    alert('승인 완료');
                }else {
                    alert('승인 실패');
                }
            }
        });
    });
});

function checkJoin() {
    let data = {
        id : $('#joinId').val(),
        pw : $('#joinPW').val(),
        name : $('#name').val()
    }
}