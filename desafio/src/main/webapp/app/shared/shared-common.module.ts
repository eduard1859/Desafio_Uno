import { NgModule } from '@angular/core';

import { DesafioSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
  imports: [DesafioSharedLibsModule],
  declarations: [JhiAlertComponent, JhiAlertErrorComponent],
  exports: [DesafioSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class DesafioSharedCommonModule {}
