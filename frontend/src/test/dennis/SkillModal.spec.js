import { mount } from "@vue/test-utils";
import SkillModal from "@/components/modals/profile/SkillModal.vue";
import UserSkill from "@/models/userSkill";

let wrapper;

const skills = [
    { id: 1, name: 'JavaScript' },
    { id: 2, name: 'Vue.js' },
    { id: 3, name: 'CSS' }
];

const selectedSkill = new UserSkill(null);
const open = false;
const user = { id: 0 };

beforeAll(() => {
    wrapper = mount(SkillModal, {
        props: {
            open: open,
            skills: skills,
            user: user,
            selectedSkill: selectedSkill
        }
    });
})

describe('SkillModal', function() {
    it('Sanity test', function() {
        expect(1).toBe(1);
    })

    it('Should emit an close event when close button is clicked', () => {
        wrapper.find('.modal__close').trigger('click');
        expect(wrapper.emitted().close).toBeTruthy();
    })

    it('Should render all skills in select element', () => {
        const options = wrapper.findAll('select option')
        expect(options.length).toBe(4);
        expect(options.at(1).text()).toBe('JavaScript');
        expect(options.at(2).text()).toBe('Vue.js');
        expect(options.at(3).text()).toBe('CSS');
    })

    it('Should set level based on radio button selection', () => {
        const radioButtons = wrapper.findAll('input[type="radio"]');

        radioButtons.at(1).setChecked();
        expect(wrapper.vm.getSelectedSkill.level).toBe(1);

        radioButtons.at(2).setChecked();
        expect(wrapper.vm.getSelectedSkill.level).toBe(2);

        radioButtons.at(3).setChecked();
        expect(wrapper.vm.getSelectedSkill.level).toBe(3);
    })
})