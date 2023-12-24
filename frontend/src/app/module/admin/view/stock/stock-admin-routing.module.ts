
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { PaiementAchatListAdminComponent } from './paiement-achat/list/paiement-achat-list-admin.component';
import { CategorieProduitListAdminComponent } from './categorie-produit/list/categorie-produit-list-admin.component';
import { ProduitListAdminComponent } from './produit/list/produit-list-admin.component';
import { AchatListAdminComponent } from './achat/list/achat-list-admin.component';
import { ClientListAdminComponent } from './client/list/client-list-admin.component';
import { AchatItemListAdminComponent } from './achat-item/list/achat-item-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'paiement-achat',
                            children: [
                                {
                                    path: 'list',
                                    component: PaiementAchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'categorie-produit',
                            children: [
                                {
                                    path: 'list',
                                    component: CategorieProduitListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'produit',
                            children: [
                                {
                                    path: 'list',
                                    component: ProduitListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'achat',
                            children: [
                                {
                                    path: 'list',
                                    component: AchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'client',
                            children: [
                                {
                                    path: 'list',
                                    component: ClientListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'achat-item',
                            children: [
                                {
                                    path: 'list',
                                    component: AchatItemListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class StockAdminRoutingModule { }
