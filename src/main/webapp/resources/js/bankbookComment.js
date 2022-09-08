// bankbookComment.js

const comment_btn = document.getElementById("comment_btn");
const writer = document.querySelector("#writer");
const contents = document.getElementById("contents");
const commentList = document.getElementById("commentList");
const more = document.getElementById("more");

// page 번호 담는 변수
let page = 1;
// bookNum 을 담을 변수
const bookNum = comment_btn.getAttribute("data-booknum");

getCommentList(page, bookNum);

comment_btn.addEventListener("click", function () {

    let wv = writer.value;
    let cv = contents.value;

    //------------------------ ajax -----------------------------
    // 1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    // 2. Method, URL 준비
    xhttp.open("POST", "./commentAdd");

    // 3. Enctype
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    // 4. 전송(post일 경우 파라미터 추가)
    xhttp.send("bookNum=" + bookNum + "&writer=" + wv + "&contents=" + cv);

    // 5. 응답 처리
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let result = xhttp.responseText.trim();
            console.log(result);
            result = JSON.parse(result);
            console.log(result.result);
            writer.value = "";
            contents.value = "";
            if (result.result == 1) {
                alert("댓글이 등록되었습니다.");

                for (let i = 0; i < commentList.children.length;) {
                    commentList.children[0].remove();

                }
                page = 1;

                getCommentList(page, bookNum);
            } else {

            }
        }
    }

}); // click event 끝

function getCommentList(p, bn) {
    // 1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    // 2. Method, URL
    xhttp.open("GET", "./commentList?page=" + p + "&bookNum=" + bn);

    // 3. 요청 전송
    xhttp.send();

    // 4. 응답 처리
    xhttp.addEventListener("readystatechange", function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log(xhttp.responseText);
            // 1. jsp 사용한 결과물
            //console.log(commentList.innerHTML.xhttp.responseText.trim());

            // 2. json 결과물
            let result = JSON.parse(xhttp.responseText.trim());
            // let result = document.createElement("table");
            // let resultAttr = document.createAttribute("class");
            // resultAttr.value = "table tavle-dark table-hover";
            // result.setAttributeNode(resultAttr);

            let pager = result.pager; // commentPager
            let ar = result.list; // 댓글 리스트

            for (let i = 0; i < ar.length; i++) {
                let tr = document.createElement("tr");

                let td = document.createElement("td");
                let tdText = document.createTextNode(ar[i].contents);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].writer);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");

                let d = new Date(ar[i].regDate);
                let year = d.getFullYear();
                let month = d.getMonth() + 1;
                let date = d.getDate();
                tdText = document.createTextNode(ar[i].regDate);
                // tdText = document.createTextNode(year + "/" + month + "/" + date);
                td.appendChild(tdText);
                tr.appendChild(td);


                td = document.createElement("td");
                tdText = document.createTextNode("수정");
                let tdAttr = document.createAttribute("class");
                tdAttr.value = "update";
                td.setAttributeNode(tdAttr);
                td.appendChild(tdText);
                tr.appendChild(td);
                tdAttr = document.createAttribute("data-commentnum");
                tdAttr.value = ar[i].num;
                td.setAttributeNode(tdAttr);

                td = document.createElement("td");
                tdAttr = document.createAttribute("class");
                tdAttr.value = "delete";
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-commentnum");
                tdAttr.value = ar[i].num;
                td.setAttributeNode(tdAttr);

                tdText = document.createTextNode("삭제");
                td.appendChild(tdText);
                tr.appendChild(td);


                //result.appendChild(tr);
                commentList.append(tr);

                if (page >= pager.totalPage) {
                    more.classList.add("disabled");
                } else {
                    more.classList.remove("disabled");
                }



                // console.log(ar[i]);
                // console.log(ar[i].contents);
                // console.log(ar[i].writer);
            }

            // commentList.append(result);

        }
    });
}


//------------------------ 더보기 ---------------------------
more.addEventListener("click", function () {
    page++; // page = page + 1;

    const bookNum = comment_btn.getAttribute("data-booknum");

    console.log(page);
    console.log(bookNum);

    //page = 1;

    getCommentList(page, bookNum);

});

// ------------------------------ update, delete ---------------------------------------
commentList.addEventListener("click", function (event) {
    //------------------------------------ delete -------------------------------------
    if (event.target.className == "delete") {
        let check = window.confirm("정말 삭제하시겠습니까?");

        if (check) {
            let num = event.target.getAttribute("data-commentnum");
            console.log("Num: ", num);

            // 1. XMLHTTPResquest
            const xhttp = new XMLHttpRequest();

            // 2. 요청 정보(URL, Method)
            xhttp.open("POST", "commentDelete");

            // 3. Header(enctype);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            // 4. 요청 (파라미터와 함께)
            xhttp.send("num=" + num);

            // 5. 응답 처리
            // xhttp.addEventListener("readystatechange", function() 둘 다 가능
            xhttp.onreadystatechange = function () {
                if (xhttp.readyState == 4 && xhttp.status == 200) {
                    let result = xhttp.responseText.trim();
                    console.log(result);

                    if (result == 1) {
                        alert("삭제 성공");
                        // 삭제 후 리스트 새로고침 - 단점 : 댓글 전체에서 삭제하면 더보기를 또 눌러줘야된다.
                        page = 1;
                        for (let i = 0; i < commentList.children.length;) {
                            commentList.children[0].remove();

                        }
                        getCommentList(page, bookNum);
                    } else {
                        alert("삭제 실패");
                    }
                }
            }

        }
    }
    //------------------------------------ update -------------------------------------
    if (event.target.className == "update") {
        // let contents = event.target.previousSibling.previousSibling.previousSibling;

        // console.log(contents);
        // let v = contents.innerHTML;
        // contents.innerHTML = "<textarea>"+ v +"</textarea>";

        let contents = event.target.previousSibling.previousSibling.previousSibling.innerHTML;
        let writer = event.target.previousSibling.previousSibling.innerHTML;
        let num = event.target.getAttribute("data-commentnum");
        console.log(contents);

        document.querySelector("#updateContents").value = contents;
        document.querySelector("#updateWriter").value = writer;
        document.querySelector("#num").value = num;

        document.getElementById("up").click();
    }
})

// -------------------- Modal Update Button Click ----------------
const update = document.getElementById("update");

update.addEventListener("click", function () {
    console.log("update");
    // modal에서 num, contents

    let num = document.getElementById("num").value;
    let contents = document.getElementById("updateContents").value;

    // ajax 만들어서
    // 1. XHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    // 2. request 정보
    xhttp.open("POST", "commentUpdate");

    // 3. Header 정보(Enctype)
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    // 4. 요청 실행
    xhttp.send("num=" + num + "&contents=" + contents);

    // 5. 응답 처리
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState==4 && xhttp.status==200){
            console.log(xhttp.responseText.trim());
            let result = xhttp.responseText.trim();

            if(result > 0 ) {
                alert("댓글 수정 완료");
                for (let i = 0; i < commentList.children.length;) {
                    commentList.children[0].remove();

                }
                page = 1;

                getCommentList(page, bookNum);
            
            } else {
                alert("댓글 수정 실패");
            }
        }
    }


    // 컨트롤러 프린트
})

