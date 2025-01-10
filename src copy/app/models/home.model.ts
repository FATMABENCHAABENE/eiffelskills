export interface Infos {
    id?: number; 
    surname: string;
    name: string;
    birth: Date;
}

export interface Diplome {
    id?: number; 
    obtentionDate: Date;
    name: string;
    school: string;
}

export interface ExPro {
    id?: number; 
    nameC: string;
    beginD: Date;
    endD: Date;
    job: string;
}

export interface Skills {
    id?: number; 
    domains: string;
    details: string;
}

export interface Certif {
    id?: number; 
    name: string;
    domain: string;
}

export interface Hobbie {
    id?: number; 
    description: string;
}

export interface Contact {
    id?: number; 
    type: string;
    info: string;
}

export interface Message {
    id?: number;
    surname: string;
    name: string;
    contact: string;
    date: Date;
    messagebody: string;
}