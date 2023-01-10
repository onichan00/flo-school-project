const CryptoJS = require("crypto-js");

/**
 * Hashes a given plain text string using the MD5 algorithm
 *
 * @param {string} plainText The plain text string to be hashed
 * @return {string} The hashed string
 */
export const hash = (plainText) => {
    return CryptoJS.MD5(plainText).toString();
}