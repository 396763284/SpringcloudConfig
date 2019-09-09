


export const setStorage = (name, content) => {
    if (!name) return;
    if (typeof content !== "string") {
        content = JSON.stringify(content);
    }
    sessionStorage.setItem(name,content)
}

export const getStorage = name => {
    if (!name) return;
    let content = sessionStorage.getItem(name);
    try {
        content = JSON.parse(content);
        return content;
    } catch (e) {
        return content;
    }
}

export const removeStorage = name => {
    if (!name) return;
    sessionStorage.remove(name);
}

export const clearStorage =() =>{
    sessionStorage.clear
}