import { Observable, Subject } from 'rxjs';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
    providedIn:'root'
})
/**
 * Class AlertService : Display a popup for 4 seconds with a given message
 */
export class AlertService {

    /**
     * Constructor
     * @param snackBar 
     */
    constructor(private snackBar:MatSnackBar){}

    /**
     * Method displayAlert
     * @param msg : Message to be shown
     * @param action 
     */
    displayAlert(msg: string, action?: string) {
        this.snackBar.open(msg, action, {duration : 4000});
    }
}