const KEY = "reliefLinkData";
const seed = { volunteers:[
  {id:1,name:"Ananya Sharma",age:24,gender:"Female",phone:"9876543210",email:"ananya@example.com",address:"Sector 21, Chandigarh",skills:"First aid, logistics",availability:"Weekends",emergency:"Ravi Sharma - 9876543211"},
  {id:2,name:"Rahul Verma",age:29,gender:"Male",phone:"9876543212",email:"rahul@example.com",address:"Model Town, Delhi",skills:"Driving, rescue",availability:"Full time",emergency:"Neha Verma - 9876543213"}
],resources:[
  {id:1,name:"Bottled Water",category:"Food & Water",quantity:320,unit:"bottles",location:"Central Warehouse",status:"Available"},
  {id:2,name:"First Aid Kits",category:"Medical",quantity:18,unit:"kits",location:"Medical Depot",status:"Low Stock"},
  {id:3,name:"Emergency Blankets",category:"Shelter",quantity:90,unit:"pieces",location:"North Store",status:"Available"},
  {id:4,name:"Portable Generators",category:"Equipment",quantity:4,unit:"units",location:"Central Warehouse",status:"Critical"}
],shelters:[
  {id:1,name:"Community Hall North",location:"North District",capacity:180,occupancy:124,contact:"Meera Joshi",phone:"9876500001",status:"Open"},
  {id:2,name:"St. Mary's School",location:"Riverside",capacity:240,occupancy:201,contact:"Arun Patel",phone:"9876500002",status:"Open"},
  {id:3,name:"Sports Complex",location:"East Zone",capacity:300,occupancy:72,contact:"Kavita Singh",phone:"9876500003",status:"Standby"}
],requests:[
  {id:"REQ-1042",requester:"Priya Nair",phone:"9876512345",location:"Riverside Ward 4",type:"Medical",description:"Urgent medical assistance needed for an elderly resident.",priority:"High",people:1,date:"2026-09-18T09:30",status:"In Progress",history:["Request created","Volunteer team assigned","Medical team en route"]},
  {id:"REQ-1041",requester:"Imran Khan",phone:"9876512346",location:"Old Market",type:"Food & Water",description:"Food and drinking water required for displaced families.",priority:"Medium",people:18,date:"2026-09-18T08:45",status:"Assigned",history:["Request created","Supply vehicle assigned"]},
  {id:"REQ-1040",requester:"Sunita Devi",phone:"9876512347",location:"Hill View",type:"Rescue",description:"Two families need evacuation due to flooding.",priority:"Critical",people:7,date:"2026-09-18T07:15",status:"Pending",history:["Request created"]}
]};
let state = JSON.parse(localStorage.getItem(KEY) || "null") || seed;
const listeners = new Set();
function persist(){localStorage.setItem(KEY,JSON.stringify(state));listeners.forEach(fn=>fn());}
export const store={
 get:(type)=>state[type], subscribe:(fn)=>{listeners.add(fn);return()=>listeners.delete(fn)},
 add:(type,item)=>{state[type].unshift({...item,id:type==="requests"?`REQ-${1043+state.requests.length}`:Date.now()});persist()},
 update:(type,id,item)=>{const i=state[type].findIndex(x=>String(x.id)===String(id));if(i>-1){state[type][i]={...state[type][i],...item};persist()}},
 remove:(type,id)=>{state[type]=state[type].filter(x=>String(x.id)!==String(id));persist()},
 reset:()=>{state=structuredClone(seed);persist()}
};
