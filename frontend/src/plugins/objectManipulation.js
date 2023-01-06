/**
 * This function converts a JavaScript object, which may be a proxy object, to a JSON object.
 * It does this by first stringifying the object and then parsing it as a JSON object.
 *
 * @param {Object} obj The object to be convertex
 * @returns {Object} The JSON object
 */
export const proxyObjToJson = (obj) => {
    // Convert the object to a JSON object
    return JSON.parse(JSON.stringify(obj));
}