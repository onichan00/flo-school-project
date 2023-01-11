import dateFormat from "dateformat";

/**
 * Returns the full name of a specialist object by concatenating the first and last name and capitalizing the first letter of each
 *
 * @param {Object} specialist The specialist object
 * @returns {string} The full name of the specialist
 */
export const specialistFullName = (specialist) => {
    return (String(specialist.first_name).charAt(0).toUpperCase() + String(specialist.first_name).slice(1))
        + ' '
        + String(specialist.last_name).charAt(0).toUpperCase() + String(specialist.last_name).slice(1);
}

/**
 * Returns the full name of a user object by concatenating the first, second (if provided), and last name and capitalizing the first letter of each.
 * If middleNameAbbreviation is set to true, the second name will be abbreviated to just the first letter with a period.
 *
 * @param {Object} User The user object
 * @param {boolean} middleNameAbbreviation Whether to abbreviate the second name to just the first letter with a period
 * @returns {string} The full name of the user
 */
export const userFullName = (user, middleNameAbbreviation = false) => {
    const firstName = firstLetterUpperCase(user.first_name);
    const secondName = user.second_name && middleNameAbbreviation ? `${user.second_name.charAt(0).toUpperCase()}.` : firstLetterUpperCase(user.second_name);
    const lastName = firstLetterUpperCase(user.last_name);

    return `${firstName} ${secondName} ${lastName}`;
}

/**
 * Capitalizes the first letter of a given string.
 *
 * @param {string} value THe string to be modified
 * @returns {string} The modified string
 */
export const firstLetterUpperCase = (value) => {
    if (value) value = value.charAt(0).toUpperCase() + value.slice(1);

    return value;
}

/**
 * Formats a given date.
 *
 * @param {Date} date The date to be formatted
 * @returns {string} The formatted date
 */
export const formatDate = (date) => {
    return dateFormat(date, "dd-Mon-yyyy  hh:mm:ss")
}