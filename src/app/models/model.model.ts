export interface users {
    id?: number; 
    name: string; 
    surname: string; 
    mail: string; 
    password : string; 
    role: string; 
}

export interface mat {
    id?: number; 
    description: string; 
    major: string; 
}

export interface Modules {
    id?: number; 
    description: string; 
    major: string; 
    id_teacher: number; 
}

export interface Comp {
    id?: number; 
    description: string; 
    id_module: number;
}

export interface Eval {
    id?: number; 
    idSkill: number;
    idStudent: number;
    eval: string;
    quizzEval:string; 
}

export interface Affichage {
    id?: number; 
    idSkill: number; 
    description: string; 
    eval: string; 
    quizzeval: string; 
}

export interface AffQuizz {
    id?: number;
    descriptionMod: string;
    question :string; 
    reponseUn: string; 
    reponseDeux: string; 
    reponseTrois: string;
    reponseQuatre: string; 
    is_goodUn: boolean;
    is_goodDeux: boolean; 
    is_goodTrois: boolean;
    is_goodQuatre: boolean; 
}

export interface Qcm {
    id?:number; 
    description: string;
    idModule: number; 
}

export interface Question {
    id?: number; 
    description: string; 
    idMcq: number; 
    idSkill: number; 
}

export interface answers {
    id?: number;
    description: string; 
    is_good: boolean;
    id_question: number;
}

