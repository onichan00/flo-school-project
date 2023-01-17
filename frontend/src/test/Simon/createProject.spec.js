import { mount } from '@vue/test-utils'
import CreateProjects from "@/views/createProjects.vue";

describe('CreateProjects.vue', () => {
    let wrapper

    // Initialize the wrapper before each test
    beforeEach(() => {
        wrapper = mount(CreateProjects)
    })

    it('renders the project name input field', () => {
        // Find the input element by its name attribute
        const projectNameInput = wrapper.find('input[name="name"]')
        // Assert that the element exists
        expect(projectNameInput.exists()).toBe(true)
    })

    it('renders the project banner input field', () => {
        // Find the input element by its name attribute
        const bannerUrlInput = wrapper.find('input[name="bannerUrl"]')
        // Assert that the element exists
        expect(bannerUrlInput.exists()).toBe(true)
    })

    it('updates the data when the form is filled', () => {
        const projectNameInput = wrapper.find('input[name="name"]')
        const bannerUrlInput = wrapper.find('input[name="bannerUrl"]')
        const projectDescription = wrapper.find('textarea[name="description"]')

        projectNameInput.setValue('Test Project')
        bannerUrlInput.setValue('https://test.com/image.jpg')
        projectDescription.setValue('This is a test project')

        expect(wrapper.vm.$data.name).toBe('Test Project')
        expect(wrapper.vm.$data.bannerUrl).toBe('https://test.com/image.jpg')
        expect(wrapper.vm.$data.description).toBe('This is a test project')
    })
})


