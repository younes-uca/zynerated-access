import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CategorieProduitDto} from './CategorieProduit.model';

export class ProduitDto extends BaseDto{

    public reference: string;

    public libelle: string;

    public barcode: string;

    public discription: string;

    public prixAchatMoyen: null | number;

    public quantite: null | number;

    public seuilAlert: null | number;

    public categorieProduit: CategorieProduitDto ;
    

    constructor() {
        super();

        this.reference = '';
        this.libelle = '';
        this.barcode = '';
        this.discription = '';
        this.prixAchatMoyen = null;
        this.quantite = null;
        this.seuilAlert = null;
        this.categorieProduit = new CategorieProduitDto() ;

        }

}
