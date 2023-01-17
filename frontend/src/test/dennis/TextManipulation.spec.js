import { specialistFullName, userFullName, formatDate, firstLetterUpperCase } from "@/plugins/textManipulation";

describe('SpecialistFullName', () => {
   it('Should return the full name of a specialist', () => {
       const specialist = {
           first_name: 'john',
           last_name: 'doe'
       };

       expect(specialistFullName(specialist)).toEqual('John Doe')
    })

    it('Should return null if the specialist object is null', () => {
        expect(specialistFullName(null)).toEqual(undefined);
    })
});

describe('UserFullName', () => {
    it('Should return the full name of a user', () => {
        const user = {
            first_name: 'jane',
            second_name: 'sawyer',
            last_name: 'doe'
        };

        expect(userFullName(user)).toEqual('Jane Sawyer Doe');
    })

    it('Should return the full name of the user with a abbreviated second name', () => {
        const user = {
            first_name: 'jane',
            second_name: 'sawyer',
            last_name: 'doe'
        };

        expect(userFullName(user, true)).toEqual('Jane S. Doe');
    })

    it('Should return null if the user object is null', () => {
        expect(userFullName(null)).toEqual('No user');
    })
});

describe('FirstLetterUpperCase', () => {
    it('Should capitalize the first letter of a string', () => {
        const value = 'hello';
        expect(firstLetterUpperCase(value)).toEqual('Hello');
    })

    it('Should return null if the string is null', () => {
        const value = null;
        expect(firstLetterUpperCase(value)).toEqual(null);
    })
});

describe('FormatDate', () => {
    it('Should format a given date', () => {
        const date = new Date('2023-01-01');
        expect(formatDate(date)).toEqual('01-0+0100n-2023  01:01:00');
    })
})

