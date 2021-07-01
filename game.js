let cond=confirm("Are you Ready for Hunting Number !!!!!");
let num=Math.floor(Math.random()*100+1);
console.log(num);
let count=0;
if(cond)
{
  let parent=document.body;
  let item=document.createElement("input");
  item.type="text";
  item.id="text1";
  item.placeholder="Enter Your Number ....";
  parent.appendChild(item);
}
function enter()
{
  let val=document.getElementById("text1").value;
  let h1=document.getElementById("dynamic");
  if(Number(val)>num)
  {
    h1.textContent="Too Large,Enter Smaller Number ...";
    count++;
  }
  else if(Number(val)<num)
  {
    h1.textContent="Too Low,Enter Greater Number ...";
    count++;
  }
  else
  {
    h1.textContent=`Congratulation!! You Won in ${count} Attemp... `;
    count++;
  }
}