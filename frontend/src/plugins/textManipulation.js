import dateFormat from "dateformat";

export const specialistFullName = (specialist) => {
    let firstName = specialist.first_name.charAt(0).toUpperCase() + specialist.first_name.slice(1);
    let secondName = specialist.second_name ? specialist.second_name.charAt(0).toUpperCase() + "." : "";
    let lastName = specialist.last_name.charAt(0).toUpperCase() + specialist.last_name.slice(1);

    return `${firstName} ${secondName} ${lastName}`;
}

export const firstLetterUpperCase = (value) => {
    if (value) value = value.charAt(0).toUpperCase() + value.slice(1);

    return value;
}

export const formatDate = (date) => {
    return dateFormat(date, "dd-Mon-yyyy  hh:mm:ss")
}