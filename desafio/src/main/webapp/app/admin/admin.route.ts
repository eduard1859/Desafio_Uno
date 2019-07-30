import { Routes } from '@angular/router';

import { configurationRoute, docsRoute, healthRoute, logsRoute, metricsRoute } from './';

import { UserRouteAccessService } from 'app/core';

const ADMIN_ROUTES = [configurationRoute, docsRoute, healthRoute, logsRoute, metricsRoute];

export const adminState: Routes = [
  {
    path: '',
    data: {
      authorities: []
    },
    canActivate: [UserRouteAccessService],
    children: ADMIN_ROUTES
  }
];
