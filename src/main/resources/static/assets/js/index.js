$(document).ready(function() {
    console.log('JS 연결 완료');
    var finished = false;

    // 회원가입
    $('#join').on('click', function () {
        let data = {
            id : $('#joinId').val(),
            password : $('#joinPw').val(),
            name : $('#joinName').val(),
            email : $('#joinEmail').val(),
            rePw : $('#repeatJoinPw').val()
        }

        if(data.rePw !== data.password){
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
            success : function (member) {
                if(member === 1){
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

    // 뒤로가기
    $('#back').on('click', function () {
        window.location.href = '/index';
    });

    // 글쓰기
    $('#write').on('click', function() {
        let data = {
            title : $('#title').val(),
            content : $('#content').val(),
            writer : $('#writer').val(),
            mno : $('#mno').val()
        }

        $.ajax({
            data : data,
            type : 'post',
            url : 'rest/write',
            success : function() {
                alert('글 등록 완료');
                window.location.href = '/index' ;
            }
        });
    });

    // 추천
    $('#reco').on('click', function() {
        let data = {
            bno : $('#bno').val()
        }

        $.ajax({
            data : data,
            type : 'put',
            url : '/rest/reco',
            success : function () {
                alert('추천 완료');
                location.reload();
            }

        });
    });

    // 글 삭제
    $('#delete').on('click', function() {
        let data = {
            bno : $('#bno').val()
        }

        $.ajax({
            data : data,
            type : 'delete',
            url : '/rest/delete',
            success : function() {
                alert('삭제 완료');
                window.location.href = '/index';
            }
        });
    });

    // 수정
    $('#update').on('click', function() {
        let data = {
            title : $('#title').val(),
            content : $('#content').val(),
            writer : $('#writer').val(),
            bno : $('#bno').val()
        }

        $.ajax({
            data : data,
            type : 'put',
            url : '/rest/update',
            success : function() {
                alert('수정 완료!');
                window.location.href = '/select/' + data.bno;
            }
        });
    });


    // 글 수정 버튼
    $('#updateBtn').on('click', function() {
        let bno = $('#bno').val();
        window.location.href = '/update/' + bno;
    });

    // 댓글
    $('#reply').on('click', function() {
        console.log('클릭확인');
        let data = {
            rcontent : $('#rcontent').val(),
            rwriter : $('#rwriter').val(),
            mno : $('#mno').val(),
            bno : $('#bno').val()
        }

        console.log(data.rcontent);
        console.log(data.rwriter);
        console.log(data.mno);
        console.log(data.bno);

        $.ajax({
            data : data,
            type : 'post',
            url : '/rest/reply',
            success : function() {
                alert('댓글 완료');
                window.location.href = '/select/' + data.bno;
            }
        });
    });


});

function up(temp) {
    let data = {
        bno : $('#bno').val(),
        rno : temp
    }

    $.ajax({
        data : data,
        type : 'put',
        url : '/rest/up',
        success : function() {
            location.reload();
        }
    });
}

function down(temp) {
    let data = {
        bno : $('#bno').val(),
        rno : temp
    }

    $.ajax({
        data : data,
        type : 'put',
        url : '/rest/down',
        success : function() {
            location.reload();
        }
    });
}