import { TestBed } from '@angular/core/testing';

import { UserInService } from './user-in.service';

describe('UserInService', () => {
  let service: UserInService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserInService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
