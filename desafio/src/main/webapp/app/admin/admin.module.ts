import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DesafioSharedModule } from 'app/shared';
/* jhipster-needle-add-admin-module-import - JHipster will add admin modules imports here */

import {
  adminState,
  LogsComponent,
  JhiMetricsMonitoringComponent,
  JhiHealthModalComponent,
  JhiHealthCheckComponent,
  JhiConfigurationComponent,
  JhiDocsComponent
} from './';

@NgModule({
  imports: [
    DesafioSharedModule,
    /* jhipster-needle-add-admin-module - JHipster will add admin modules here */
    RouterModule.forChild(adminState)
  ],
  declarations: [
    LogsComponent,
    JhiConfigurationComponent,
    JhiHealthCheckComponent,
    JhiHealthModalComponent,
    JhiDocsComponent,
    JhiMetricsMonitoringComponent
  ],
  entryComponents: [JhiHealthModalComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DesafioAdminModule {}
