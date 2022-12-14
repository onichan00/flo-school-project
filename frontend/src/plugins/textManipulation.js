import dateFormat from "dateformat";

export const specialistFullName = (specialist) => {
    let firstName = specialist.first_name.charAt(0).toUpperCase() + specialist.first_name.slice(1);
    let secondName = specialist.second_name ? specialist.second_name.charAt(0).toUpperCase() + "." : "";
    let lastName = specialist.last_name.charAt(0).toUpperCase() + specialist.last_name.slice(1);

    return `${firstName} ${secondName} ${lastName}`;
}

/**
 * Function that returns the full name of a user object by getting the first, second and last name and glueing them together
 * @param user User object
 * @param middleNameAbbreviation Boolean to decide if the second name output should be one letter with a dot or the full second name
 * @returns A string combining the first name, second name and last name with uppercase
 */
export const userFullName = (user, middleNameAbbreviation = false) => {
    const firstName = firstLetterUpperCase(user.first_name);
    const secondName = user.second_name && middleNameAbbreviation ? `${user.second_name.charAt(0).toUpperCase()}.` : firstLetterUpperCase(user.second_name);
    const lastName = firstLetterUpperCase(user.last_name);

    return `${firstName} ${secondName} ${lastName}`;
}

export const firstLetterUpperCase = (value) => {
    if (value) value = value.charAt(0).toUpperCase() + value.slice(1);

    return value;
}

export const formatDate = (date) => {
    return dateFormat(date, "dd-Mon-yyyy  hh:mm:ss")
}