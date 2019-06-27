var websocket;

window.onload = function () {
   var counterField = document.getElementById("counterField");
   websocket = new WebSocket("ws://localhost:8080/01HelloWorld_war_exploded/ws/counter")

   websocket.onmessage = function (msg) {
      counterField.innerText = msg.data;
   }

   websocket.onopen = function () {
      console.log("connection successfully established");
   }

   websocket.onclose = function () {
      console.log("connection closed by server");
   }

   websocket.onerror = function (msg) {
      console.log("error:" + message);
   }
}

function resetCounter() {
   websocket.send("reset");
}