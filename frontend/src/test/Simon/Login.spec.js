import { mount } from '@vue/test-utils'
import Login from "@/views/Login.vue";
import axios from 'axios';

jest.mock('axios');

describe('Login.vue', () => {
    let wrapper

    beforeEach(() => {
        wrapper = mount(Login)
        wrapper.setData({
            email: 'test@test.com',
            password: 'password',
        });
    })

    it('renders the email and password input fields', () => {
        const emailInput = wrapper.find('input[name="email"]')
        const passwordInput = wrapper.find('input[name="password"]')
        expect(emailInput.exists()).toBe(true)
        expect(passwordInput.exists()).toBe(true)
    })

    it('renders the submit button', () => {
        const submitButton = wrapper.find('button[type="submit"]')
        expect(submitButton.exists()).toBe(true)
    })
})
