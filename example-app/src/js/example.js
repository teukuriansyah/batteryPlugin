import { battery } from 'battery';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    battery.echo({ value: inputValue })
}
