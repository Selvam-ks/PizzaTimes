import { TestBed } from '@angular/core/testing';

import { AdminCrdService } from './admin-crd.service';

describe('AdminCrdService', () => {
  let service: AdminCrdService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminCrdService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
