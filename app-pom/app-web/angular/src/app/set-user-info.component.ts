import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserInfoService } from './user-info/user-info.service';
import { TransactionService } from './term/transaction.service';

@Component({
    template: '',
    providers: []
})

export class SetUserInfoComponent implements OnInit {
    
    constructor(
        private route: ActivatedRoute,
        private userInfoService: UserInfoService,
        private transactionService: TransactionService,
        private router: Router
    ) {

    }

    ngOnInit() {
        const termId = this.route.snapshot.paramMap.get('termid');
        this.transactionService.setTerminalId(termId);
        this.userInfoService.setUserInfo({termId})
                .then(() => this.router.navigateByUrl(''));
    }
}
