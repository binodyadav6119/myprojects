function validate() {  
var msg;  
if(document.myForm.userPass.value.length>5){  
msg="good";  
}  
else{  
msg="poor";  
}  
document.getElementById('mylocation').innerText=msg;  
 }  
  
function getCube()
{
    var nu = document.getElementById("number").value
    alert("cube is "+nu*nu*nu)
    // document.getElementById('number').innerText="testing inner text";  

}

function printName()
{
    var name = document.form1.name1.value
    alert("name is "+name)
}
function msg()
{
    emp={
        "name": "binod",
        "age": 25
    }

    //Array
    var a =[]
    a.push("binod");
    a.push("yadav")
    for(var i=0;i<a.length;i++)
    {
        console.log(a[i]);
    }
    

    // history.back()
    // setTimeout(
    //     function(){
    //         alert("asdfg")
    //     },2000
    // )

    alert("testing alert box"+emp["name"])
    // open("https://google.com")
}