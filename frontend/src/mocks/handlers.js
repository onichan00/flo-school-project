import {rest} from "msw";

export const handlers = [
    rest.get("http://localhost:8080/api/users/specialists/applications", (req, res, ctx) => {
        const responseBody = [
                {
                    id: 1,
                    email: "test@email.com",
                    first_name: "first_name",
                    second_name: "second_name",
                    last_name: "last_name",
                    photo: "photo",
                    bio: "bio",
                    company: "company",
                    phone: "phone",
                    address: "address",
                    zipCode: "zipCode",
                    city: "city",
                    specialistType: "specialistType"
                },
                {
                    id: 2,
                    email: "test@email.com",
                    first_name: "first_name",
                    second_name: "second_name",
                    last_name: "last_name",
                    photo: "photo",
                    bio: "bio",
                    company: "company",
                    phone: "phone",
                    address: "address",
                    zipCode: "zipCode",
                    city: "city",
                    specialistType: "specialistType"
                },
                {
                    id: 3,
                    email: "test@email.com",
                    first_name: "first_name",
                    second_name: "second_name",
                    last_name: "last_name",
                    photo: "photo",
                    bio: "bio",
                    company: "company",
                    phone: "phone",
                    address: "address",
                    zipCode: "zipCode",
                    city: "city",
                    specialistType: "specialistType"
                }]

        return res(
            ctx.status(200),
            ctx.json({responseBody})
        )
    })
]