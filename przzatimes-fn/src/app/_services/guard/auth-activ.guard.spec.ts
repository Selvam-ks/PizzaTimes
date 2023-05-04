import { TestBed } from '@angular/core/testing';

import { AuthActivGuard } from './auth-activ.guard';

describe('AuthActivGuard', () => {
  let guard: AuthActivGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AuthActivGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
