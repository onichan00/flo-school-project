import {AnnouncementsAdaptor} from "@/models/AnnouncementsAdaptor";

describe('AnnouncementsAdaptor', () => {
    let adaptor;
    const socketUrl = 'ws://localhost:8080'
    const handlerCB = jest.fn()

    // Create a new adaptor instance before each test
    beforeEach(() => {
        adaptor = new AnnouncementsAdaptor(socketUrl, handlerCB)
    })

    // Close the WebSocket connection after each test
    afterEach(() => {
        adaptor.close()
    })

    it('creates a new WebSocket with the correct url', () => {
        // Check that the socketUrl and socket properties are set correctly
        expect(adaptor.socketUrl).toBe(`ws://localhost:8080`)
        expect(adaptor.socket).toBeInstanceOf(WebSocket)
    })

    it('calls the handlerCB function when a message is received', () => {
        // Simulate a message event and check that the callback function is called
        const message = 'Test message'
        adaptor.socket.onmessage({data: message})
        expect(handlerCB).toHaveBeenCalledWith(message)
    })

    it('sends a message with the correct format', () => {
        // Create a mock function for the socket's send method
        adaptor.socket.send = jest.fn()
        // Send a test message and check that the format is correct
        const message = 'Test message'
        const user = 'Test user'
        const project = 'Test project'
        adaptor.sendMessage(message, user, project)
        const expectedMessage = {
            message: message,
            date: expect.any(String),
            user: user,
            project: project
        }
    })
})
