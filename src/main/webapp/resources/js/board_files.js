// board_files.js

const addFiles = document.getElementById("addFiles"); // form
const fileAdd = document.getElementById("fileAdd"); // button
    let count = 0;
    let idx = 0;

    fileAdd.addEventListener("click", function () {

        if (count > 4) {
            alert("파일 추가는 최대 5개까지만 가능합니다.");
            return;
        }
        
        document.getElementById("attachmentFile").style.display="block";
        
        // 파일 삭제 코드
        //  <div class="mb-3">
        //     <label for="files" class="form-label">File</label>
        //     <input type="file" name="files" class="form-control" id="files">
        //     <button type = "button" class = "del">파일 삭제</button>
        //   </div>

        // 파일 추가 코드
        //  <div class="mb-3">
        //     <label for="files" class="form-label">File</label>
        //     <input type="file" name="files" class="form-control" id="files">
        //   </div>
        
        //부모 Element div 생성
        let div = document.createElement("div"); //<div></div>
        let c = document.createAttribute("class"); //class=""
        c.value = "mb-3";                           //class="mb-3"
        div.setAttributeNode(c);                    //<div class="mb-3" </div>
        c = document.createAttribute("id");
        c.value ="file" + idx;
    
        div.setAttributeNode(c);
        
        
        //자식 Element Label 생성
        let label = document.createElement("label"); //<label></label>
        // let labelText = document.createTextNode("File"); //      "File"
        // label.appendChild(labelText);               // <label>File</label>
        let labelClass = document.createAttribute("class"); // class=""
        labelClass.value = "form-label";                //class="form-label"
        label.setAttributeNode(labelClass);             //<label class="form-label" </label>
        labelClass = document.createAttribute("for");   //for="";
        labelClass.value = "files";                     //for = "files"
        label.setAttributeNode(labelClass);             //<label for="files" class="form-label" </label>
        
        div.appendChild(label);

        //자식 Element Input 생성
        let input = document.createElement("input");    //<input>
        let inputAttr = document.createAttribute("type");   //type=""
        inputAttr.value = "file";                           //type="file"
        input.setAttributeNode(inputAttr);              //<input type = "file"
        
        inputAttr = document.createAttribute("name");   //name=""
        inputAttr.value = "files";                       //name ="files"       
        input.setAttributeNode(inputAttr);               //<input type="file" name="files"
        
        inputAttr = document.createAttribute("class");      //class=""
        inputAttr.value = "form-control";                   //class="form-control"
        input.setAttributeNode(inputAttr);                   //<input type="file" name="files" class="form-control"
        
        inputAttr = document.createAttribute("id");           //id=""
        inputAttr.value = "files";                            //id="files"          
        input.setAttributeNode(inputAttr);                       //<input type = "file" name = "files" class="form-control" id="file"
        
        div.appendChild(input);
        
        
        
        // 삭제 Button Element
        let button = document.createElement("button");
        let buttonContents = document.createTextNode("삭제");
        button.appendChild(buttonContents);
        
        let buttonAttr = document.createAttribute("type");
        buttonAttr.value="button";
        button.setAttributeNode(buttonAttr);
        
        buttonAttr = document.createAttribute("class");
        buttonAttr.value = "del btn btn-danger";
        button.setAttributeNode(buttonAttr);

        buttonAttr = document.createAttribute("title");
        buttonAttr.value = idx;
        button.setAttributeNode(buttonAttr);

        div.appendChild(button);
        
        addFiles.prepend(div);

        count++;
        idx++;
    });

    addFiles.addEventListener("click", function(event){
        if(event.target.classList[0] =='del') {
            alert("파일 삭제 alert");
        }
    });
    
    // fileAdd.addEventListener("click", function(){
        //     console.log("test-!");
        
        //     addFiles.style.display="block";
        //     let input = document.createElement("input"); // <input>
        //     let ch = document.createAttribute("type"); // type : 속성은 부모자식 관계가 아님
        //     ch.value = "file"; //type = "file"
        //     input.setAttributeNode(ch);
        //     addFiles.append(input);
        
        // });
