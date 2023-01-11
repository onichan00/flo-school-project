
export class AnnouncementsAdaptor {
    socketUrl;          // socket-url
    socket = null;  // new socket pending handshake of connection

    constructor(socketUrl, handlerCB) {
        this.socketUrl = socketUrl;
        this.handler = handlerCB;

        this.socketUrl = socketUrl.replace("http://", "ws://");
        this.socket = new WebSocket(this.socketUrl);

        this.socket.onopen = () => console.log("Open socket");
        this.socket.onmessage = (msg) => handlerCB(msg.data);
        this.socket.onerror = (err) => console.log(err);
        this.socket.onclose = () => console.log("Closed socket");
        console.log(`Created announcements adaptor on ${this.socketUrl}`);
    }

    sendMessage(message, user, project) {
        console.log("New announcement:", message);
        const date = new Date();

        this.socket.send(JSON.stringify({
            message: message,
            date: getDate(),
            user: user,
            project: project
        }));
    }

    close() {
        console.log(`Closed announcements adaptor on ${this.socketUrl}`)
        this.socket.close();
    }
}

function getDate() {
    let today = new Date();
    const dd = String(today.getDate()).padStart(2, '0');
    const mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    const yyyy = today.getFullYear();

    return today = mm + '/' + dd + '/' + yyyy;
}

